package threads;

public class RunnablesOne {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            int i = 0;
            @Override
            public void run() {
                for (; i < 10_000; i++) {
                    System.out.println(Thread.currentThread().getName() + " i is " + i);
                }
            }
        };
        
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
//        t1.setDaemon(true);
        t1.start();
        t2.start();
        System.out.println(Thread.currentThread().getName() + ": Main exiting...");
    }
}
