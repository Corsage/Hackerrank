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
     * Just need to go thru the range and figure out
     * which numbers are divisble by k.
     * 
     * Optimization(s):
     * It is known that a number subtracted by its
     * reverse is always divisible by 9
     * (simple proof).
     * 
     */

    /**
     * Time complexity: O(n) -- simple.
     */
    static int beautifulDays2(int i, int j, int k) {
        int days = 0;

        for (int x = i; x <= j; x++) {
            int temp = Math.abs(x - reverse(x)) % k;
            if (temp == 0) {
                days++;
            }
        }

        return days;
    }

    // A helper method to reverse numbers for us.
    static int reverse(int n) {
        int temp = 0;

        while (n != 0) {
            temp = (temp * 10) + (n % 10);
            n /= 10;
        }

        return temp;
    }
}