package multithreading.callable_future;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Class CallableFutureSample
 *
 * @author Kamila Meshcheryakova
 * created by 30.11.2020
 */
public class CallableFutureSample {
    public static void main(String[] args) throws Exception {
        Callable task = () -> {
            return "Hello, World!";
        };
        FutureTask<String> future = new FutureTask<>(task);
        new Thread(future).start();
        System.out.println(future.get());

    }
}
