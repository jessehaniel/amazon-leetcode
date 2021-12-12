package dev.jessehaniel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKMostFrequentWords {

    // Given an array of strings words and an integer k, return the k most frequent strings.
    // Return the answer sorted by the frequency from highest to lowest.
    // Sort the words with the same frequency by their lexicographical order.

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        List<String> res = new ArrayList<>(freq.keySet());
        res.sort((w1, w2) -> freq.get(w1).equals(freq.get(w2)) ?
            w1.compareTo(w2) : freq.get(w2) - freq.get(w1));

        return res.subList(0, k);
    }

    public static void main(String[] args) {
        var app = new TopKMostFrequentWords();
        var output = app.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
        System.out.println(output);//["i", "love"]
        output = app.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}
            , 4);
        System.out.println(output);//["the","is","sunny","day"]
    }

}
