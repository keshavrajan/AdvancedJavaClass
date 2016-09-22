import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;



public class RunnablesOne {
	public static void startThreads() throws InterruptedException
	{
//		Runnable r = new Runnable() {
////			private int i=0;
//			@Override
//			public void run() {
//				
//				for(int i = 0; i < 10000; i++) { // i is Method local variable
////				for(; i < 10000; i++) { // i is a member of an object on the heap
//
//
//					System.out.println(Thread.currentThread().getName() + " i is " + i);
//				}				
//			}
//		};
//		
//		Thread t1 = new Thread(r);
//		Thread t2 = new Thread(r);
//		//t1.setDaemon(true);
//		t1.start();
//		t2.start();
//		System.out.println(Thread.currentThread().getName() + " : Main existing ...i" );

		Callable<String> cs = new Callable<String>() {
			@Override
			public String call() throws Exception
			{
				Thread.sleep(2000);
				return "Hello";
			}
		};

		Callable<Long> cl = new Callable<Long>() {
			@Override
			public Long call() throws Exception
			{
				Thread.sleep(2000);
				return Long.MAX_VALUE;
			}
		};

		
		ExecutorService es = Executors.newFixedThreadPool(1);
		
		Future<String> h1 = es.submit(cs);
		Future<Long> h2 = es.submit(cl);

		int i = 0;
		while(!h1.isDone() && !h2.isDone())
		{
			Thread.sleep(10);
			System.out.println("Both jobs are Running " + (++i * 10) + "ms");
		}
		
		while(!h1.isDone())
		{
			Thread.sleep(10);
			System.out.println("Job ONE is Running " + (++i * 10) + "ms");			
		}

		while(!h2.isDone())
		{
			Thread.sleep(10);
			System.out.println("Job TWO is Running " + (++i * 10) + "ms");			
		}
		
		try {
			String result = h1.get();
			System.out.println("Result : " + result);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Long result2 = h2.get();
			System.out.println("Result : " + result2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		if(!h1.isCancelled())
		{
			boolean isCancelled = h1.cancel(true);
			System.out.println(isCancelled);
		}
		
		es.shutdown();

	}
}
