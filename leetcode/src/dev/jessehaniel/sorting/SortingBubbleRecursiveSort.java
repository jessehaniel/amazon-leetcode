package dev.jessehaniel.sorting;

import java.util.Arrays;

public class SortingBubbleRecursiveSort implements Sorting {

    // Recursive Bubble Sort has no performance/implementation advantages,
    // but can be a good question to check one’s understanding of Bubble Sort and recursion.

    @Override
    public int[] sort(int[] array) {
        return this.bubbleSort(array, array.length);
    }

    private int[] bubbleSort(int[] array, int arraySize) {
        // Base case
        if (arraySize == 1) {
            return array;
        }
        // One pass of bubble sort. After this pass, the largest element is moved (or bubbled) to end.
        for (int i = 0; i < arraySize - 1; i++) {
            if (array[i] > array[i + 1]) {
                swap(array, i);
            }
        }
        // Largest element is fixed, recur for remaining array
        return bubbleSort(array, arraySize - 1);
    }

    private void swap(int[] array, int i) {
        int temp = array[i];
        array[i] = array[i + 1];
        array[i + 1] = temp;
    }

    public static void main(String[] args) {
        var app = new SortingBubbleRecursiveSort();
        var output = app.sort(new int[]{64, 34, 25, 12, 22, 11, 90});
        System.out.println(Arrays.toString(output));
    }
}
