package SortingAlgorithms;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    /**
     * Merge sort uses the recursion to sort an array.
     * 1) Breaks arrays in half
     * 2) Base case: when array.length is 1.
     * 3) Use merge() to put arrays together.
     */
    public static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }
        int midIndex = array.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

        return merge(left, right);
    }

    public static int[] merge(int[] array1, int[] array2) {
        int[] combined = new int[array1.length + array2.length];
        int index = 0;
        int i = 0;
        int j = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                combined[index] = array1[i];
                index++;
                i++;
            } else {
                combined[index] = array2[j];
                index++;
                j++;
            }
        }
        while (i < array1.length) {
            combined[index] = array1[i];
            index++;
            i++;
        }
        while (j < array2.length) {
            combined[index] = array2[j];
            index++;
            j++;
        }
        return combined;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 3, 7, 8};
        int[] array2 = {2, 4, 5, 6};
        System.out.println(Arrays.toString(merge(array1, array2)));

        int[] arr = new int[10001];
        for (int i = 0; i < 10001; i++) {
            arr[i] = i;
        }
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            int randomIndexToSwap = rand.nextInt(arr.length);
            int temp = arr[randomIndexToSwap];
            arr[randomIndexToSwap] = arr[i];
            arr[i] = temp;
        }



        long start = System.nanoTime();
        int[] sortedArray = mergeSort(arr);
        long end = System.nanoTime();
        System.out.println("Computation time of Merge Sort: " + (end - start));
    }
}
