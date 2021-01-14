package tasks;

import java.util.Arrays;

/**
 * Class Matrix demonstrates the task:
 * find is there a number in 2D sorted array.
 *
 * @author Kamila Meshcheryakova
 * created by 14.01.2021
 */
public class Matrix {
    public static void main(String[] args) {
        int[][] matrix = {{20, 30, 40, 41, 45, 46, 49}, {50, 52, 53, 56, 60, 70}, {80, 84, 88, 89, 90, 100}};
        int number = 100;
        boolean flag = false;
        long startOne = System.currentTimeMillis();
        for (int[] arr : matrix) {
            int index = Arrays.binarySearch(arr, number);
            if (index >= 0) {
                flag = true;
                break;
            }
        }
        System.out.println(flag);
        System.out.println(System.currentTimeMillis() - startOne);
        /* 3 ways:
        1. use binary search in every single array in 2D array.
        2. use binary search in every single array in 2D array parallel.
        3. using list - add all elements and use binary search.
         */
    }
}
