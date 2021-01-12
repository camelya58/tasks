package tasks;

import java.util.Arrays;

/**
 * Class CalculatePairsInArray demonstrates the task execution:
 * calculate quantity of pairs in array. Pair is equal positive and negative numbers.
 *
 * @author Kamila Meshcheryakova
 * created by 12.01.2021
 */
public class CalculatePairsInArray {
    public static void main(String[] args) {
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10 * (Math.random() > 0.5 ? 1 : -1));
        }
        System.out.println(Arrays.toString(array));

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) continue;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] == 0) continue;
                if ((array[i] + array[j]) == 0) {
                    count++;
                    array[i] = 0;
                    array[j] = 0;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
