package multithreading.fork_join_pool;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Class ForkJoinPoolExample
 *
 * @author Kamila Meshcheryakova
 * created by 14.12.2020
 */
public class ForkJoinPoolExample {

    static long number = 10_000_000_000L;
    static int numberOfThreads = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        System.out.println(new Date());
        ForkJoinPool forkJoinPool = new ForkJoinPool(numberOfThreads);
        System.out.println(forkJoinPool.invoke(new MyFork(0, number)));
        System.out.println(new Date());
    }

    private static class MyFork extends RecursiveTask<Long> {

        private long from;
        private long to;

        public MyFork(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if ((to - from) <= number / numberOfThreads) {
                long sum = 0;
                for (long i = from; i <= to; i++) {
                    sum += 1;
                }
                return sum;
            } else {
                long middle = (to + from) / 2;
                MyFork subtask = new MyFork(from, middle);
                subtask.fork();
                MyFork subtask2 = new MyFork(middle + 1, to);
                Long value = subtask2.compute();
                return subtask.join() + value;
            }
        }
    }
}
