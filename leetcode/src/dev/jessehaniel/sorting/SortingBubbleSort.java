package dev.jessehaniel.sorting;

import java.util.Arrays;

public class SortingBubbleSort implements Sorting {

    // Time Complexity: O(nˆ2)
    // Space Complexity: O(1)
    // PS: Due to its simplicity, bubble sort is often used to introduce the concept of a sorting algorithm.

    public int[] sort(int[] array) {
        // Bubble Sort is the simplest sorting algorithm that works by
        // repeatedly swapping the adjacent elements if they are in wrong order.

        for (int i = 0; i < array.length; i++) {
            // Optimization
            boolean swap = false;
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }

        return array;
    }

    public static void main(String[] args) {
        var app = new SortingBubbleSort();
        var output = app.sort(new int[]{64, 34, 25, 12, 22, 11, 90});
        System.out.println(Arrays.toString(output));//11, 12, 22, 25, 34, 64, 90
    }

}
