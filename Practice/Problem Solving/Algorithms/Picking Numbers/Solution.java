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

public class Solution {

    /**
     * Initial Logic:
     * Just need to go thru the array and create subarrays.
     * 
     * However, since we are taking the absolute value this
     * means that we can add n + 1 or n - 1 to the subarray.
     * 
     * But, if we add n + 1 then n - 1 will have a difference
     * greater than 1 hence not meeting the criteria; same
     * if we add n - 1 then n + 1.
     * 
     */

     /**
      * Time complexity: O(n) -- using a HashMap.
      */
     public static int pickingNumbers(List<Integer> a) {
         int max = 0;

         Map<Integer, Integer> freq = new HashMap<>();

         for (int i = 0; i < a.size(); i++) {
             if (freq.containsKey(a.get(i))) {
                 freq.put(a.get(i), freq.get(a.get(i)) + 1);
             } else {
                 freq.put(a.get(i), 1);
             }
         }

         for (int i : freq.keySet()) {
             int temp = freq.get(i);
             int above = 0;
             int below = 0;

             if (freq.containsKey(i + 1)) {
                 above = freq.get(i + 1);
             }

             if (freq.containsKey(i - 1)) {
                 below = freq.get(i - 1);
             }

             int highest = Math.max(temp + above, temp + below);

             if (max < highest) {
                 max = highest;
             }
         }

         return max;
     }

    /**
     * Time complexity: O(n) + O(m) -- original.
     */
    public static int pickingNumbers2(List<Integer> a) {
        int max = 0;
        int[] arr = new int[Collections.max(a) + 1];

        // Each number gets its own placement in the array.
        for (int i = 0; i < a.size(); i++) {
            arr[a.get(i)]++;
        }

        // Looping thru in ascending order, we match pairs and add.
        for (int i = 0; i < arr.length - 1; i++) {
            if ((arr[i] + arr[i + 1]) > max) {
                max = arr[i];
            }
        }

        return max;
    }
}