package async;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class AsyncFileReader {
    public static String tName() {
        return Thread.currentThread().getName();
    }
    
    public static void delay(int secs) {
        try {
            Thread.sleep(secs * 1000);
        } catch (InterruptedException ie) {
            System.out.println(tName() + " was interrupted!");
        }
    }
    public static void main(String[] args) throws Throwable {
        CompletableFuture<String> cfOne = CompletableFuture.supplyAsync(()->{
            System.out.println("cfOne starting in " + tName());
            delay(3);
            if (Math.random() < 1) throw new RuntimeException("Bwaahhaahahaha!");
            System.out.println("cfOne completing");
            return "cfOne " + LocalTime.now();
        });
        
        CompletableFuture<String> cfTwo = CompletableFuture.supplyAsync(()->{
            System.out.println("cfTwo starting in " + tName());
            delay(ThreadLocalRandom.current().nextInt(1,5));
            System.out.println("cfTwo completing");
            return "cfTwo " + LocalTime.now();
        });
        
    
        CompletableFuture<String> fileRead = new CompletableFuture<>();
        
        AsynchronousFileChannel afc = AsynchronousFileChannel.open(
                Paths.get("text.txt"), StandardOpenOption.READ);
        
        ByteBuffer bb = ByteBuffer.allocate(4096);
        afc.read(bb, 0, new Object[]{"Read", bb}, new CompletionHandler<Integer, Object[]>(){
            @Override
            public void completed(Integer result, Object[] attachment) {
                System.out.println(Thread.currentThread().getName() + " handling "
                    + attachment[0] + " operation with " + result + " bytes");
                ByteBuffer readByteBuffer = (ByteBuffer)(attachment[1]);
                readByteBuffer.flip();
                CharBuffer cb = Charset.defaultCharset().decode(readByteBuffer);
                String readString = cb.toString();
                System.out.println(Thread.currentThread().getName() + " read:\n" + readString);
                fileRead.complete("returned from CompletableFuture:\n" 
                        + Thread.currentThread().getName() + " read:\n" + readString);
            }

            @Override
            public void failed(Throwable exc, Object[] attachment) {
                fileRead.completeExceptionally(exc);
            }
        });

        System.out.println("jobs submitted, waiting to complete");
        
        cfOne
                .handle((v,e)->e!= null ? "Ooops!" : v)
                .applyToEither(cfTwo, s->"Second stage: " + s)
                .thenCombineAsync(fileRead, (a,b)->"Combine completed, file produced:\n" 
                    + b + "\nText stuff created:\n" + a)
                .thenAccept(s->System.out.println("****RESULT: " + s))
                .join();
        
        delay(5);
     
    }
}
