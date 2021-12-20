package dev.jessehaniel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HackerRankSockMerchant {

    // There is a large pile of socks that must be paired by color.
    // Given an array of integers representing the color of each sock,
    // determine how many pairs of socks with matching colors there are.
    // Example
    //   n=?
    //   ar = (1,2,1,2, 1, 3, 2)
    //   There is one pair of color 1 and one of color 2.
    //   There are three odd socks left, one of each color. The number
    //   of pairs is 2.
    // Function Description
    //   Complete the sockMerchant function in the editor below.
    //   sockMerchant has the following parameter(s):
    //     • int n: the number of socks in the pile
    //     • int ar[n]: the colors of each sock

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        Map<Integer, Integer> pairs = new HashMap<>();
        for (int i : ar) {
            pairs.merge(i, 1, Integer::sum);
        }
        int countPairs = 0;
        for (Map.Entry<Integer, Integer> entry : pairs.entrySet()) {
            if (entry.getValue()/2 > 0)
                countPairs += entry.getValue()/2;
        }
        return countPairs;
    }

    public static void main(String[] args) {
        var output = sockMerchant(9, List.of(10, 20, 20, 10, 10, 30, 50, 10, 20));
        System.out.println(output);
        output = sockMerchant(10, List.of(1, 1, 3, 1, 2, 1, 3, 3, 3, 3));
        System.out.println(output);
    }

}
