package multithreading.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Class ThreadPoolExecutorSample
 *
 * @author Kamila Meshcheryakova
 * created by 02.12.2020
 */
public class ThreadPoolExecutorSample {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);

        for(int i = 0; i < 10; i++) {
            service.submit(new Runnable() {
                public void run()
                {
                    // тут мы загружаем что-то тяжелое из интернета.
                }
            });
        }
        service.shutdown();
    }
}
