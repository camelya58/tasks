package multithreading.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Class ExecutorServiceSample demonstrates the work of thread pool.
 *
 * @author Kamila Meshcheryakova
 * created by 02.12.2020
 */
public class ExecutorServiceSample {
    public static void main(String[] args) throws InterruptedException {
        // creates fixed pool for 5 threads
        ExecutorService executor = Executors.newFixedThreadPool(5);
        // creates 10 tasks to execute by thread pool
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    doExpensiveOperation(finalI);
                }
            });
        }
        // this method forbids to add new tasks in a pool
        executor.shutdown();
        // set time for completing the tasks
        executor.awaitTermination(5, TimeUnit.SECONDS);
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}
/* Output example
pool-1-thread-2, localId=2
pool-1-thread-1, localId=1
pool-1-thread-3, localId=3
pool-1-thread-1, localId=7
pool-1-thread-1, localId=9
pool-1-thread-4, localId=4
pool-1-thread-5, localId=5
pool-1-thread-2, localId=6
pool-1-thread-1, localId=10
pool-1-thread-3, localId=8
*/
