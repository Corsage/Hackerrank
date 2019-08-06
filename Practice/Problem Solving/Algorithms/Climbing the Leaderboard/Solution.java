import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    /**
     * Initial Logic:
     * Just need to keep checking her score with the already
     * submitted scores.
     * 
     * Scores is given in descending order.
     * Since it's descending, just need to check beside each
     * to see if there's a rank change.
     * 
     * Alice's scores are given in ascending order.
     * 
     * Optimization(s):
     * If we use the fact that her scores are given in
     * ascending, then we can start from the bottom
     * of the scores list and compare.
     */

    /**
     * Time complexity: O(n + m) -- optimized.
     */
    static int[] climbingLeaderboard2(Integer[] scores, Integer[] alice) {
        int ranks[] = new int[alice.length];
        int total = 0;

        // Index for alice.
        int index = 0;

        // Scores are given in descending order.
        for (int i = scores.length - 1; i >= 0; i--) {
            // Rankings based off of unique scores only.
            if (i == 0 || scores[i] != scores[i - 1]) {

                // Alice's scores are in ascending order.
                // Continuously comparing lowest scores.
                while (index < alice.length && alice[index] < scores[i]) {
                    ranks[index] = total;
                    index++;
                }

                total++;
            }
        }

        for (int i = 0; i < ranks.length; i++) {
            if (i >= index) {
                ranks[i] = 1;
            } else {
                ranks[i] = total  - ranks[i] + 1;
            }
        }

        return ranks;
    }

    /**
     * Time complexity: O(n * m) -- original.
     */
    static int[] climbingLeaderboard2(int[] scores, int[] alice) {
        int[] ranks = new int[alice.length];

        for (int i = 0; i < alice.length; i++) {
            int rank = 1;

            for (int j = 0; j < scores.length - 1; j++) {
                if (scores[j] > alice[i] && scores[j] != scores[j + 1]) {
                    rank++;
                    if (j == scores.length - 2 && alice[i] < scores[scores.length - 1]) {
                        rank++;
                    }
                } else if (alice[i] >= scores[j]) {
                    break;
                }
            }

            ranks[i] = rank;
        }

        return ranks;
    }
}