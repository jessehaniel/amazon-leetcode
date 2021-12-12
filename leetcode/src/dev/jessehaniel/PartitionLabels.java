package dev.jessehaniel;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    // You are given a string `s`. We want to partition the string into
    // as many parts as possible so that each letter appears in at most one part.
    // Return a list of integers representing the size of these parts.

    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            last[s.charAt(i) - 'a'] = i;
        }
        int j = 0;
        int anchor = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            j = Math.max(j, last[s.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        final PartitionLabels app = new PartitionLabels();
        //[9,7,8] -> "ababcbaca", "defegde", "hijhklij"
        System.out.println(app.partitionLabels("ababcbacadefegdehijhklij"));
        //[10] -> "eccbbbbdec"
        System.out.println(app.partitionLabels("eccbbbbdec"));
        //[8, 4] -> "abccaddb", "effe"
        System.out.println(app.partitionLabels("abccaddbeffe"));
    }

}
