import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    /**
     * Initial Logic:
     * Just need to compare all possibilities for keyboards and drives.
     * Compare each, and save the highest total cost within budget.
     * Initialize the total cost as -1 because that's what we return
     * if she can't afford anything.
     * 
     * Optimization(s):
     * Sorting one in ascending, while the other in descending
     * will allow us to only have to visit each element once.
     * This is because the sum of the previous will be greater
     * or less than the current.
     */


     /**
      * Time complexity: O((n + m) * (log (n + m)) -- optimized.
      */
     static int getMoneySpent(Integer[] keyboards, Integer[] drives, int b) {
         int total = -1;

         // Ascending order.
         Arrays.sort(keyboards);
         // Descending order.
         Arrays.sort(drives, Collections.reverseOrder());

         for (int i = 0; i < keyboards.length; i++) {
             for (int j = 0; j < drives.length; j++) {
                 temp = keyboards[i] + drives[j];

                 // We can break because the next one
                 // will always be a lower total.
                 if (temp > total && temp <= b) {
                     total = temp;
                     break;
                 }
             }
         }

         return total;
     }

    /**
     * Time complexity: O(n * m) solution -- original.
     */
    static int getMoneySpent2(int[] keyboards, int[] drives, int b) {
        int totalCost = -1;

        for (int i = 0; i < keyboards.length; i++) {
            for (int j = 0; j < drives.length; j++) {
                int temp = keyboards[i] + drives[j];
                if (temp > totalCost && temp <= b) {
                    totalCost = temp;
                }
            }
        }

        return totalCost;
    }
}