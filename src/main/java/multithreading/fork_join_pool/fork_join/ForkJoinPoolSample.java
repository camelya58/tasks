package multithreading.fork_join_pool.fork_join;

import java.util.concurrent.ForkJoinPool;

/**
 * Class ForkJoinPoolSample demonstrates the example of converting to binary using ForkJoinPool and RecursiveTask<T>.
 *
 * @author Kamila Meshcheryakova
 * created by 14.12.2020
 */
public class ForkJoinPoolSample {
    private String binaryRepresentationMethod(int x) {
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            return binaryRepresentationMethod(b) + result;
        }
        return result;
    }


    public static void main(String[] args) {
        ForkJoinPoolSample forkJoinPoolSample = new ForkJoinPoolSample();
        String result1 = forkJoinPoolSample.binaryRepresentationMethod(6);
        System.out.println(result1);

        System.out.println();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        String result2 = forkJoinPool.invoke(new BinaryRepresentationTask(6));
        System.out.println(result2);
    }

}
