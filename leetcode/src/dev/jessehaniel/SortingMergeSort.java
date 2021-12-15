package dev.jessehaniel;

import java.util.Arrays;

public class SortingMergeSort implements Sorting {

    // Time Complexity: θ(nLogn) in all 3 cases (worst, average and best)
    // Space Complexity: O(n)

    // It divides the input array into two halves, calls itself for the two halves,
    // and then merges the two sorted halves.

    @Override
    public int[] sort(int[] array) {
        this.mergeSort(array, 0, array.length - 1);
        return array;
    }

    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            // Find the middle point
            int middle = left + (right - left)/2;

            // Sort first and second halves
            this.mergeSort(array, left, middle);
            this.mergeSort(array, middle + 1, right);

            // Merge the sorted halved
            this.merge(array, left, middle, right);
        }
    }

    private void merge(int[] array, int left, int middle, int right) {
        // Find sizes of two sub-arrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Copy data to temp arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, middle + 1, rightArray, 0, n2);

        // Merge the temp arrays
        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            array[k++] = leftArray[i] <= rightArray[j] ? leftArray[i++] : rightArray[j++];
        }

        // Copy remaining elements of leftArray and rightArray, if any.
        while (i < n1) {
            array[k++] = leftArray[i++];
        }
        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }

    public static void main(String[] args) {
        var app = new SortingMergeSort();
        var output = app.sort(new int[]{64, 34, 25, 12, 22, 11, 90});
        System.out.println(Arrays.toString(output));
    }
}
