import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'minMoves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int minMoves(List<Integer> arr) {
    // Write your code here
        int indexForZero = 0;
        int indexForOne = 0;
        int countForZero = 0;
        int countForOne = 0;
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            if (arr.get(i) == 0) {
                countForZero = Math.abs(i - indexForZero);
                indexForZero++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr.get(i) == 1) {
                countForOne = Math.abs(i - indexForOne);
                indexForOne++;
            }
        }
        return Math.min(countForOne, countForZero);
    }

}
