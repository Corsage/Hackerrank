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
     * Go thru each row/column/diagonal and ensure the sum of them is 15.
     * However, there are a 3 unique positions in a 3x3 square (like tic-tac-toe).
     * 1) Corners, 2) Middle, 3) Rest
     * 
     * Corner pieces and middle piece must remain constant.
     * This means in the corner we can only have 2, 4, 6, 8.
     * Order matters as well, if we have an 8, it must be adjacent to 4 and 6.
     * 
     * The middle must be 5.
     * 
     * The leaves 1, 3, 7, 9 as the remaining pieces.
     * 1 must be between 8 and 6.
     * 3 must be between 8 and 4.
     * 7 must be between 6 and 2.
     * 9 must be between 4 and 2.
     * 
     * With all of this in mind, there's actually not many unique magic squares,
     * best would be to just brute force check and return min.
     */

    /**
     * Time complexity: O(1) -- We do not care about what square is given.
     */
    static int formingMagicSquare(int[][] s) {
        int[] costs = new int[8];

        int[][][] magicSquares = {
            { { 8, 3, 4 }, { 1, 5, 9 }, { 6, 7, 2 } },
            { { 6, 1, 8 }, { 7, 5, 3 }, { 2, 9, 4 } },
            { { 2, 7, 6 }, { 9, 5, 1 }, { 4, 3, 8 } },
            { { 4, 9, 2 }, { 3, 5, 7 }, { 8, 1, 6 } },
            { { 4, 3, 8 }, { 9, 5, 1 }, { 2, 7, 6 } },
            { { 2, 9, 4 }, { 7, 5, 3 }, { 6, 1, 8 } },
            { { 6, 7, 2 }, { 1, 5, 9 }, { 8, 3, 4 } },
            { { 8, 1, 6 }, { 3, 5, 7 }, { 4, 9, 2 } }
        };

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < magicSquares.length; k++) {
                    costs[k] += Math.abs(s[i][j] - magicSquares[k][i][j]);
                }
            }
        }

        return Arrays.stream(costs).min().getAsInt();
    }
}