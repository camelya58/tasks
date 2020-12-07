package multithreading.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Class ShutDownNowSample demonstrates the difference between methods shutDown and shutDownNow.
 *
 * @author Kamila Meshcheryakova
 * created by 02.12.2020
 */
public class ShutDownNowSample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++) {
            final int localId = i;
            executor.submit(() -> doExpensiveOperation(localId));
        }

        executor.shutdownNow().forEach(System.out::println);
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}
/*
Должно получиться что-то вроде:
pool-1-thread-1, localId=1
pool-1-thread-2, localId=2
pool-1-thread-3, localId=3
pool-1-thread-4, localId=4
pool-1-thread-5, localId=5
java.util.concurrent.FutureTask@7e6cbb7a was not completed
java.util.concurrent.FutureTask@7c3df479 was not completed
java.util.concurrent.FutureTask@7106e68e was not completed
java.util.concurrent.FutureTask@7eda2dbb was not completed
java.util.concurrent.FutureTask@6576fe71 was not completed

 */
