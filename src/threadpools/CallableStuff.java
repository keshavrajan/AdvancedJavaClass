package threadpools;

import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyCallable implements Callable<String> {

    private static int nextId = 0;
    private int myId = nextId++;

    @Override
    public String call() throws Exception {
        System.out.println("Callable " + myId + " starting in "
                + Thread.currentThread().getName());
        try {
            Thread.sleep((int) (Math.random() * 4000) + 1000);
            if (Math.random() > 0.8) throw new SQLException("Database broke!");
        } catch (InterruptedException ie) {
            System.out.println("Callable " + myId + " shutting down");
            return myId + " canceled at " + LocalTime.now();
        }
        return myId + " completed normally at " + LocalTime.now();
    }
}

public class CallableStuff {

    private static final int NUM_JOBS = 8;

    public static void main(String[] args) {
        List<Future<String>> jobs = new ArrayList<>();
        ExecutorService es = Executors.newFixedThreadPool(2);
        for (int i = 0; i < NUM_JOBS; i++) {
            jobs.add(es.submit(new MyCallable()));
        }
        
        for (int i = 0; i < jobs.size(); i++) {
            System.out.println("awaiting job " + i);
            if (Math.random() > 0.7) {
                jobs.get(i).cancel(true);
                System.out.println("oops, canceled job " + i);
            }
            try {
                String res = jobs.get(i).get();
                System.out.println("Job " + i);
            } catch (ExecutionException ee) {
                System.out.println("job " + i + " failed with exception " 
                        + ee.getCause().getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Job " + i + " threw interrupted exception");
            } catch (CancellationException ce) {
                System.out.println("Job " + i + " shutdown");
            }
        }
        es.shutdown();
    }
}
