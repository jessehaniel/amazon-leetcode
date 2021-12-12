package dev.jessehaniel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SearchSuggestions {
    /*
     * Complete the 'searchSuggestions' function below.
     *
     * The function is expected to return a 2D_STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY repository
     *  2. STRING customerQuery
     *
     */

    public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {
        // Write your code here
        if (customerQuery.length() < 2) {
            return Collections.emptyList();
        }
        List<List<String>> result = new ArrayList<>();
        String partial = customerQuery.substring(0, 2);
        result.add(searchWord(repository, partial, 2));
        for (int i = 3; i <= customerQuery.length(); i++) {
            partial = customerQuery.substring(0, i);
            result.add(searchWord(repository, partial, i));
        }
        return result;
    }

    private static List<String> searchWord(List<String> repository, String query, int endIndex) {
        return repository.stream()
            .filter(w -> w.length() >= endIndex && w.substring(0, endIndex).equals(query))
            .sorted()
            .limit(3)
            .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        //["mobile", "moneypot", "monitor"]
        //["mouse", "mousepad"]
        //["mouse", "mousepad"]
        //["mouse", "mousepad"]
        List<String> repository = List.of("mobile", "mouse", "moneypot", "monitor", "mousepad");
        System.out.println(SearchSuggestions.searchSuggestions(repository, "mouse"));
        //["baggage", "bags", "banner"]
        //["baggage", "bags"]
        //["bags", "mousepad"]
        repository = List.of("baggage", "bags", "banner");
        System.out.println(SearchSuggestions.searchSuggestions(repository, "bags"));
        //["baggage", "bags", "banner"]
        //["baggage", "bags"]
        //["bags", "mousepad"]
        repository = List.of("code", "codePhone", "coddle", "coddles", "codes");
        System.out.println(SearchSuggestions.searchSuggestions(repository, "coddle"));
    }
}
