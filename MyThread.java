public class MyThread implements Runnable {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }
    private static final Object lock = new Object();
    private static int currentThread = 0;

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (lock) {
                while (!name.equals("Thread-" + (currentThread + 1))) {
                    try {
                        Thread.sleep(1000);
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                System.out.println(name);
                currentThread = (currentThread + 1) % 3;
                lock.notifyAll();
            }
        }
    }
}