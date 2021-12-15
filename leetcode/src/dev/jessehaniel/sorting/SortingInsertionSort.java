package dev.jessehaniel.sorting;

import java.util.Arrays;

public class SortingInsertionSort implements Sorting {

    // Time Complexity: O(n^2)
    // Auxiliary Space: O(1)
    // Boundary Cases: Insertion sort takes maximum time to sort if elements are sorted in reverse order.
    // And it takes minimum time (Order of n) when elements are already sorted.

    // Insertion sort is a simple sorting algorithm that works similar
    // to the way you sort playing cards in your hands.
    // The array is virtually split into a sorted and an unsorted part.
    // Values from the unsorted part are picked and placed at
    // the correct position in the sorted part.

    @Override
    public int[] sort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            // Move elements of arr[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j+1] = key;
        }

        return array;
    }

    public static void main(String[] args) {
        var app = new SortingInsertionSort();
        var output = app.sort(new int[]{64, 34, 25, 12, 22, 11, 90});
        System.out.println(Arrays.toString(output));
    }
}
