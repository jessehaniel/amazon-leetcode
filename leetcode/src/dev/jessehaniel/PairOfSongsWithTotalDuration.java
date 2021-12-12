package dev.jessehaniel;

public class PairOfSongsWithTotalDuration {

    // You are given a list of songs where the ith song has a duration of time[i] seconds.
    // Return the number of pairs of songs for which their total duration in seconds is divisible by 60.
    // Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.

    public int numPairsDivisibleBy60(int[] time) {
        int[] remainders = new int[60];
        int count = 0;
        for (int t : time) {
            if (t % 60 == 0) { // check if a%60==0 && b%60==0
                count += remainders[0];
            } else { // check if a%60+b%60==60
                count += remainders[60 - t % 60];
            }
            remainders[t % 60]++; // remember to update the remainders
        }
        return count;
    }

    public static void main(String[] args) {
        var app = new PairOfSongsWithTotalDuration();
        var output = app.numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40});
        System.out.println(output);//3
        output = app.numPairsDivisibleBy60(new int[]{60, 60, 60});
        System.out.println(output);//3
    }
}
