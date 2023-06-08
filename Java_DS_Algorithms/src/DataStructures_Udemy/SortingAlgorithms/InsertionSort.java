package DataStructures_Udemy.SortingAlgorithms;

import java.util.Random;


public class InsertionSort {
    /**
     * Insertion Sorting Algorithm. Sorting an array in place.
     * @param array : The array to be sorted.
     */
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j > -1 && temp < array[j]) {
                array[j + 1] = array[j];
                array[j] = temp;
                j--;
            }
        }
    }


    public static void main(String[] args) {

        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr[i] = i;
        }
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            int randomIndexToSwap = rand.nextInt(arr.length);
            int temp = arr[randomIndexToSwap];
            arr[randomIndexToSwap] = arr[i];
            arr[i] = temp;
        }



        long start = System.currentTimeMillis();
        insertionSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("Computation time of Insertion Sort: " + (end - start));
    }
}
