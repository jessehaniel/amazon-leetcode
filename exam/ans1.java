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
     * Complete the 'maximumQuality' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY packets
     *  2. INTEGER channels
     */

    public static long maximumQuality(List<Integer> packets, int channels) {
    // Write your code here
        if (packets == null || packets.isEmpty()) {
            return 0;
        }
        if (packets.size() == 1) {
            return packets.get(0);
        }
        if (channels <= 0) {
            throw new IllegalArgumentException();
        }
        Collections.sort(packets);
        int n = channels - 1;
        int median = 0;
        while(n-- > 0) {
            median += packets.get(packets.size()-1);
            packets.remove(packets.size()-1);
        }
        return findMedian(packets, median);
    }
    
    private static long findMedian(List<Integer> packets, long median) {
        long val = 0;
        if (packets.size() % 2 == 0) {
            double d1 = (double) packets.get(packets.size()/2);
            double d2 = (double) packets.get(packets.size()/2-1);
            double result = (d1+d2)/2.0;
            val = (long) Math.ceil(result);
        } else {
            val = packets.get(packets.size()/2);
        }
        return median + val;
    }

}

