package multithreading.blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Class BlockingQueueSample demonstrates the use of BlockingQueue and ExecutorService.
 *
 * @author Kamila Meshcheryakova
 * created by 25.11.2020
 */
public class BlockingQueueSample {

    public static void main(String[] args) throws Exception {

        BlockingQueue queue = new ArrayBlockingQueue(32);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(producer);
        executorService.submit(consumer);

        Thread.sleep(2000);

        executorService.shutdownNow();

    }
}
