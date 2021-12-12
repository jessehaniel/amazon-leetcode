package dev.jessehaniel;

import java.util.Arrays;

public class KClosestPointsToOrigin {

    // Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
    // return the k closest points to the origin (0, 0).
    // The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
    // You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is
    // in).

//    public int[][] kClosest(int[][] points, int k) {
//        Arrays.sort(points, Comparator.comparingInt(this::squaredDistance));
//        return Arrays.copyOf(points, k);
//    }

    public int[][] kClosest(int[][] points, int k) {
        return quickSelect(points, k);
    }

    private int[][] quickSelect(int[][] points, int k) {
        int left = 0;
        int right = points.length - 1;
        int pivotIndex = points.length;
        while (pivotIndex != k) {
            // Repeatedly partition the array
            // while narrowing in on the kth element
            pivotIndex = partition(points, left, right);
            if (pivotIndex < k) {
                left = pivotIndex;
            } else {
                right = pivotIndex - 1;
            }
        }
        // Return the first k elements of the partially sorted array
        return Arrays.copyOf(points, k);
    }

    private int partition(int[][] points, int left, int right) {
        int[] pivot = choosePivot(points, left, right);
        int pivotDist = squaredDistance(pivot);
        while (left < right) {
            // Iterate through the range and swap elements to make sure
            // that all points closer than the pivot are to the left
            if (squaredDistance(points[left]) >= pivotDist) {
                int[] temp = points[left];
                points[left] = points[right];
                points[right] = temp;
                right--;
            } else {
                left++;
            }
        }

        // Ensure the left pointer is just past the end of
        // the left range then return it as the new pivotIndex
        if (squaredDistance(points[left]) < pivotDist)
            left++;
        return left;
    }

    private int[] choosePivot(int[][] points, int left, int right) {
        // Choose a pivot element of the array
        return points[left + (right - left) / 2];
    }

    private int squaredDistance(int[] point) {
        // Calculate and return the squared Euclidean distance
        return point[0] * point[0] + point[1] * point[1];
    }

    public static void main(String[] args) {
        var app = new KClosestPointsToOrigin();
        var output = app.kClosest(new int[][]{{1,3}, {-2,2}}, 1);
        System.out.println(output);//[[-2,2]]
        output = app.kClosest(new int[][]{{3,3}, {5,1}, {-2,4}}, 2);
        System.out.println(output);//[[3,3], [-2,4]]
    }

}
