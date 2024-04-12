public class Main {
    public static void main(String[] args) {
        Thread[] threads = new Thread[3];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new MyThread("Thread-" + (i + 1)));
            threads[i].start();
        }
    }
}
