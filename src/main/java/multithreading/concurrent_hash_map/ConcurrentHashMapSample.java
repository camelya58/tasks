package multithreading.concurrent_hash_map;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Class ConcurrentHashMapSample demonstrates the use of ConcurrentHashMap and ExecutorService.
 *
 * @author Kamila Meshcheryakova
 * created by 25.11.2020
 */
public class ConcurrentHashMapSample {
    public static void main(String[] args) throws Exception {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

        Producer producer = new Producer(map);
        Consumer consumer = new Consumer(map);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(producer);
        executorService.submit(consumer);

        Thread.sleep(2000);

        executorService.shutdownNow();
        //finally 5 lines have to be printed
    }
}
