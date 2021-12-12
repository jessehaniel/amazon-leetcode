package dev.jessehaniel;

import java.util.Arrays;

public class ReoderDataLogFiles {

    // You are given an array of `logs`. Each log is a space-delimited string of words,
    // where the first word is the `identifier`.
    //
    // There are two types of logs:
    // - Letter-logs: All words (except the identifier) consist of lowercase English letters.
    // - Digit-logs: All words (except the identifier) consist of digits.
    //
    // Reorder these logs so that:
    // 1. The letter-logs come before all digit-logs.
    // 2. The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them
    // lexicographically by their identifiers.
    // 3. The digit-logs maintain their relative ordering.

    // Return the final order of the logs.

    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (String a, String b) -> {
            int firstCharA = a.indexOf(" ") + 1;
            int firstCharB = b.indexOf(" ") + 1;

            // digit log == true, letter log == false
            boolean aType = Character.isDigit(a.charAt(firstCharA));
            boolean bType = Character.isDigit(b.charAt(firstCharB));

            if (aType && bType) {
                // Rule 3: maintain relative digit log order
                return 0;
            } else if (bType) {
                // Rule 1: digit logs follow letter logs
                return -1;
            } else if (aType) {
                // Rule 1: digit logs follow letter logs
                return 1;
            }
            // Rule 2a: letter logs sorted lexicographically
            int comp = a.substring(firstCharA).compareTo(b.substring(firstCharB));
            // Rule 2b: letter logs sorted by ids if tied
            return comp != 0 ? comp : a.compareTo(b);
        });
        return logs;
    }

    public static void main(String[] args) {
        ReoderDataLogFiles app = new ReoderDataLogFiles();
        String[] input = new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        String[] output = app.reorderLogFiles(input);
        //["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
        System.out.println(Arrays.toString(output));
        input = new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"};
        output = app.reorderLogFiles(input);
        //["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
        System.out.println(Arrays.toString(output));
        input = new String[]{"1 n u", "r 527", "j 893", "6 14", "6 82"};
        output = app.reorderLogFiles(input);
        //["1 n u", "6 14", "6 82", "r 527", "j 893"]
        System.out.println(Arrays.toString(output));
    }
}
