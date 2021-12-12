package dev.jessehaniel;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

    // Given a string paragraph and a string array of the banned words banned,
    // return the most frequent word that is not banned.
    // It is guaranteed there is at least one word that is not banned, and that the answer is unique.
    // The words in paragraph are case-insensitive and the answer should be returned in lowercase.

    public String mostCommonWord(String paragraph, String[] banned) {

        // 1). replace the punctuations with spaces,
        // and put all letters in lower case
        String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();

        // 2). split the string into words
        String[] words = normalizedStr.split("\\s+");

        Set<String> bannedWords = new HashSet<>();
        Collections.addAll(bannedWords, banned);

        Map<String, Integer> wordCount = new HashMap<>();
        // 3). count the appearance of each word, excluding the banned words
        for (String word : words) {
            if (!bannedWords.contains(word)) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        // 4). return the word with the highest frequency
        return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();

    }

    public static void main(String[] args) {
        var app = new MostCommonWord();
        var output = app.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"});
        System.out.println(output);//ball
        output = app.mostCommonWord("a.", new String[]{});
        System.out.println(output);//a
        output = app.mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"});
        System.out.println(output);//b
    }

}
