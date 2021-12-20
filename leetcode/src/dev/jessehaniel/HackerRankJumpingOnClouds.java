package dev.jessehaniel;

import java.util.List;

public class HackerRankJumpingOnClouds {

    // There is a new mobile game that starts with consecutively numbered clouds.
    // Some clouds are thunderheads and others are cumulus.
    // The player can jump on any cumulus cloud having a number that is equal
    // to the number of the current cloud plus 1 or 2.
    // The player must avoid the thunderheads. Determine the minimum number of jumps
    // it will take to jump from the starting position to the last cloud. It is always possible to win the game.
    //
    // For each game, you will get an array of clouds numbered 0 if they are safe or 1 if they must be avoided.

    public static int jumpingOnClouds(List<Integer> clouds) {
        int count = -1;
        for (int i = 0; i < clouds.size(); i++, count++) {
            if (i < clouds.size() - 2 && clouds.get(i + 2) == 0) {
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        var output = jumpingOnClouds(List.of(0, 0, 1, 0, 0, 1, 0));
        System.out.println(output);//4
    }

}
