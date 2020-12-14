package multithreading.synchronize;

/**
 * Класс SynchronizedBlock
 *
 * @author Kamila Meshcheryakova
 * created 09.12.2020
 */
public class SynchronizedBlock {
    public static void main(String[] args) {
        MyRunnableImpl myRunnable = new MyRunnableImpl();
        Thread thread1 = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable);
        Thread thread3 = new Thread(myRunnable);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Counter {
    volatile static int count = 0;
}

class MyRunnableImpl implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            doWork();
        }
    }

    private void doWork() {
        print();
        Counter.count++;
        System.out.println(Counter.count);
    }

//     private synchronized void doWork() {
//         print();
//         Counter.count++;
//         System.out.println(Counter.count);
//     }
//     private void doWork() {
//         print();
//         synchronized (this) {
//             Counter.count++;
//             System.out.println(Counter.count);
//         }
//     }

    private void print() {
        System.out.println("Yeah!!!");
    }
}