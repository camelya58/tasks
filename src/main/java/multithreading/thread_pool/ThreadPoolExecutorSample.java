package multithreading.thread_pool;

import java.util.concurrent.*;

/**
 * Class ThreadPoolExecutorSample demonstrates the work of thread pool.
 *
 * @author Kamila Meshcheryakova
 * created by 02.12.2020
 */
public class ThreadPoolExecutorSample {
    public static void main(String[] args) throws InterruptedException {
        // creates blockingQueue for 10 tasks
        LinkedBlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>(10);
        for (int i = 1; i <= 10; i++) {
            int id = i;
            blockingQueue.add(() -> doExpensiveOperation(id));
        }
        // creates pool of threads with params: size of main pool, max size, time to keep thread alive, time unit, queue
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                3, 5, 1000, TimeUnit.MILLISECONDS, blockingQueue);
        // runs main threads
        executor.prestartAllCoreThreads();
        //  this method forbids to add new tasks in a pool
        executor.shutdown();
        // set time for completing the tasks
        executor.awaitTermination(5, TimeUnit.SECONDS);
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}
/*
   Example output
pool-1-thread-2, localId=2
pool-1-thread-3, localId=3
pool-1-thread-1, localId=1
pool-1-thread-3, localId=5
pool-1-thread-2, localId=4
pool-1-thread-3, localId=7
pool-1-thread-1, localId=6
pool-1-thread-3, localId=9
pool-1-thread-2, localId=8
pool-1-thread-1, localId=10
*/