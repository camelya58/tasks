package tasks;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Class FrequencyNumber demonstrates the task:
 * find quantity of frequencies of some number in given array of numbers.
 *
 * @author Kamila Meshcheryakova
 * created by 14.01.2021
 */
public class FrequencyNumber {
    public static void main(String[] args) {
        int[] array = new int[30];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 15);
        }
        System.out.println(Arrays.toString(array));

        Map<Integer,Long> f = Arrays.stream(array).boxed().
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(f.get(13));
    }
}
