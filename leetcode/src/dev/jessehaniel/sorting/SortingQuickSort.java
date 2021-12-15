package dev.jessehaniel.sorting;

import java.util.Arrays;

public class SortingQuickSort implements Sorting {

    // Always pick first element as pivot.
    // Always pick last element as pivot (implemented below)
    // Pick a random element as pivot.
    // Pick median as pivot.

    @Override
    public int[] sort(int[] array) {
        this.quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = this.partition(array, low, high);
            this.quickSort(array, low, partitionIndex - 1);
            this.quickSort(array, partitionIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        // Index of the smaller element and indicates the right position of pivot found so far
        int smaller = low - 1;
        int pivot = array[high];

        for (int j = low; j <= high-1; j++) {
            if (array[j] < pivot) {
                smaller++;
                swap(array, smaller, j);
            }
        }
        swap(array, smaller + 1, high);
        return ++smaller;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        var app = new SortingQuickSort();
        var output = app.sort(new int[]{64, 34, 25, 12, 22, 11, 90});
        System.out.println(Arrays.toString(output));
    }
}
