package multithreading.thread_local_random;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Class ThreadLocalRandomSample demonstrates the work of static methods of ThreadLocalRandom class.
 *
 * @author Kamila Meshcheryakova
 * created by 02.12.2020
 */
public class ThreadLocalRandomSample {
    public static int getRandomIntegerBetweenNumbers(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to);
    }

    public static double getRandomDouble() {
        return ThreadLocalRandom.current().nextDouble(0, 1);
    }

    public static long getRandomLongBetween0AndN(long n) {
        return ThreadLocalRandom.current().nextLong(0, n);
    }

    public static void main(String[] args) {
        System.out.println(getRandomIntegerBetweenNumbers(14, 450));
        System.out.println(getRandomDouble());
        System.out.println(getRandomLongBetween0AndN(999999999999L));
    }
}
