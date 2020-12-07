package multithreading.callable_future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Class CallableSample demonstrates the creation of thread pool using Callable.
 *
 * Main methods of Future interface:
 * boolean cancel(boolean mayInterrupt) - stop completing of the task (if the task is in queue);
 * boolean isCancelled() - check the completing of the task, if it's cancelled - return true;
 * boolean isDone() - check the completing of the task, if it's done - return true;
 * V get() throws InterruptedException, ExecutionException - return the result of call method or throw exception
 *
 * @author Kamila Meshcheryakova
 * created by 03.12.2020
 */
public class CallableSample {
    public static void main(String[] args) throws InterruptedException {
        //1. create ThreadPoolExecutor
        ExecutorService service = Executors.newFixedThreadPool(5);

        //2. place the task to execute
        Future<String> task = service.submit(new ReverseString("Amigo"));

        //3. wait while the task is done
        while(!task.isDone()) {
            Thread.sleep(1);
        }

        //4. try to get the result of the task or exception
        try {
            System.out.println("Reversed string : " + task.get());
        } catch (Exception ie) {
            ie.printStackTrace(System.err);
        }

        //5 stop ThreadPool
        service.shutdown();
    }
}

class ReverseString implements Callable<String> {
    String str;

    ReverseString(String str) {
        this.str = str;
    }

    @Override
    public String call() throws Exception {
        StringBuilder builder = new StringBuilder(str);
        builder.reverse();
        return builder.toString();
    }
}