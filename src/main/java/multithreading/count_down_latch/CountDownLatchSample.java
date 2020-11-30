package multithreading.count_down_latch;

import java.util.concurrent.CountDownLatch;

/**
 * Class CountDownLatchSample
 *
 * @author Kamila Meshcheryakova
 * created by 30.11.2020
 */
public class CountDownLatchSample {
    public static void main(String args[]) {
        // this constructor has a parameter - the number of events that must occur before the self-blocking is released
        CountDownLatch cdl = new CountDownLatch(5);

        System.out.println("Thread starts");

        new MyThread(cdl);

        try {
            // the wait continues until the count reaches zero
            cdl.await();
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
        System.out.println("Thread terminates");
    }
}

class MyThread implements Runnable {
    CountDownLatch latch;

    MyThread(CountDownLatch c) {
        latch = c;
        new Thread(this).start();
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            // method decrements the counter by one
            latch.countDown();
        }
    }
} /* Output:

Thread starts
0
1
2
3
4
Thread terminates

*/
