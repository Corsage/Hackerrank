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
     * Just take the max int in the height array, and subtract it from k.
     */


     /**
      * Time complexity: O(n).
      */
    static int hurdleRace(int k, int[] height) {
        int max = k;

        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }

        return (max - k);
    }
}