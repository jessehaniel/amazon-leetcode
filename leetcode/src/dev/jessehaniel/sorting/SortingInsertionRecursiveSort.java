package dev.jessehaniel.sorting;

import java.util.Arrays;

public class SortingInsertionRecursiveSort implements Sorting {

    // Base Case: If array size is 1 or smaller, return.
    // Recursively sort first n-1 elements.
    // Insert last element at its correct position in sorted array.

    @Override
    public int[] sort(int[] array) {
        return this.insertionSort(array, array.length);
    }

    private int[] insertionSort(int[] array, int length) {
        // Base case
        if (length <= 1) {
            return array;
        }
        // Sort first n-1 elements
        insertionSort(array, length - 1);

        // Insert last element at its correct position in sorted array.
        int last = array[length - 1];
        int j = length - 2;

        // Move elements of arr[0..i-1], that are greater than key,
        // to one position ahead of their current position
        while (j >= 0 && array[j] > last) {
            array[j + 1] = array[j];
            j--;
        }
        array[j+1] = last;

        return array;
    }

    public static void main(String[] args) {
        var app = new SortingInsertionRecursiveSort();
        var output = app.sort(new int[]{64, 34, 25, 12, 22, 11, 90});
        System.out.println(Arrays.toString(output));
    }
}
