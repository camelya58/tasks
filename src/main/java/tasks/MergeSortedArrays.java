package tasks;

import java.util.Arrays;

/**
 * Class MergeSortedArrays demonstrates the merging of two sorted arrays in one sorted array without using sorting.
 *
 * @author Kamila Meshcheryakova
 * created by 12.01.2021
 */
public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {2, 6, 8, 13, 25, 46, 57, 68, 79, 80};
        int[] arr2 = {3, 24, 35, 56, 78, 89, 100, 240, 400};
        int[] array = new int[arr1.length + arr2.length];
        int index = 0;
        int arr1Index = 0;
        int arr2Index = 0;
        boolean arr1Finished = false;
        while (true) {
            if (arr1[arr1Index] >= arr2[arr2Index]) {
                array[index] = arr2[arr2Index];
                arr2Index++;
                if (arr2Index == arr2.length) {
                    break;
                }
            } else {
                array[index] = arr1[arr1Index];
                arr1Index++;
                if (arr1Index == arr1.length) {
                    arr1Finished = true;
                    break;
                }
            }
            index++;
        }
        if (arr1Finished) {
            for (int i = arr2Index; i < arr2.length; i++) {
                    array[++index] = arr2[i];
            }
        } else {
            for (int i = arr1Index; i < arr1.length; i++) {
                array[++index] = arr1[i];
            }
        }

        System.out.println(Arrays.toString(array));

    }
}
