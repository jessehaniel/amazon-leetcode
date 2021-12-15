package dev.jessehaniel;

import java.util.Arrays;

public class SortingSelectionSort implements Sorting {

    // Time Complexity: O(nˆ2)
    // Space Complexity: O(1)
    // PS: never takes more than O(n) swaps

    public int[] sort(int[] array) {
        // Find the minimum element in unsorted array
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        var app = new SortingSelectionSort();
        var output = app.sort(new int[]{64, 25, 12, 22, 11});
        System.out.println(Arrays.toString(output));//11,12,22,25,64
    }

}
