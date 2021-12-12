package dev.jessehaniel;

import java.util.stream.IntStream;

public class MedianTwoSortedArrays {

    // Given two sorted arrays nums1 and nums2 of size m and n respectively,
    // return the median of the two sorted arrays.
    // The overall run time complexity should be O(log (m+n)).

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        int[] mergedArray = IntStream.concat(IntStream.of(nums1), IntStream.of(nums2)).sorted().toArray();
        return size % 2 == 0 ? (mergedArray[(size/2)-1] + mergedArray[size/2])/2.0 : mergedArray[size/2];
    }

    public static void main(String[] args) {
        var app = new MedianTwoSortedArrays();
        var result = app.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        System.out.println(result);//2.00000
        result = app.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(result);//2.50000
        result = app.findMedianSortedArrays(new int[]{0,0}, new int[]{0,0});
        System.out.println(result);//0.00000
        result = app.findMedianSortedArrays(new int[]{}, new int[]{1});
        System.out.println(result);//1.00000
        result = app.findMedianSortedArrays(new int[]{2}, new int[]{});
        System.out.println(result);//2.00000
    }
}
