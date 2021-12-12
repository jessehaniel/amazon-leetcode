package dev.jessehaniel;

public class MinimumDifficultyJobSchedule {

    // You want to schedule a list of jobs in `d` days.
    // Jobs are dependent (i.e To work on the `i-th` job, you have to finish all the jobs `j` where `0 <= j < i`).
    //
    // You have to finish **at least** one task every day.
    // The difficulty of a job schedule is the sum of difficulties of each day of the `d` days.
    // The difficulty of a day is the maximum difficulty of a job done in that day.
    //
    // Given an array of integers `jobDifficulty` and an integer `d`.
    // The difficulty of the `i-th` job is `jobDifficulty[i]`.
    //
    // Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.

    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (d > n) {
            return -1;
        }
        int[][] F = new int[d + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            F[1][i] = Math.max(F[1][i - 1], jobDifficulty[i - 1]);
        }
        for (int i = 2; i <= d; i++) {
            for (int j = i; j <= n; j++) {
                F[i][j] = Integer.MAX_VALUE;
                int currMax = 0;
                for (int k = j; k >= i; k--) {
                    currMax = Math.max(currMax, jobDifficulty[k - 1]);
                    F[i][j] = Math.min(F[i][j], F[i - 1][k - 1] + currMax);
                }
            }
        }
        return F[d][n];
    }

    public static void main(String[] args) {
        var app = new MinimumDifficultyJobSchedule();
        var output = app.minDifficulty(new int[]{6, 5, 4, 3, 2, 1}, 2);
        System.out.println(output);//7
        output = app.minDifficulty(new int[]{9, 9, 9}, 4);
        System.out.println(output);//-1
        output = app.minDifficulty(new int[]{1, 1, 1}, 3);
        System.out.println(output);//3
        output = app.minDifficulty(new int[]{7, 1, 7, 1, 7, 1}, 3);
        System.out.println(output);//15
        output = app.minDifficulty(new int[]{11, 111, 22, 222, 33, 333, 44, 444}, 6);
        System.out.println(output);//843
    }

}
