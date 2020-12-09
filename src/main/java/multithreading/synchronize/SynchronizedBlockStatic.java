package multithreading.synchronize;

/**
 * Класс SynchronizedBlockStatic
 *
 * @author Kamila Meshcheryakova
 * created 09.12.2020
 */
public class SynchronizedBlockStatic {
    volatile static int counter = 0;

    public synchronized static void increment() {
        counter++;
    }

//    public static void increment() {
//        synchronized(SynchronizedBlockStatic.class) {
//            counter++;
//        }
//    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new R2());
        Thread thread2 = new Thread(new R2());
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter);
    }
}

class R2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            SynchronizedBlockStatic.increment();
        }
    }
}
