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
     * Just need to check if the student times
     * are below or equal to 0.
     * 
     * Then just compare it with the required
     * students.
     */

    /**
     * Time complexity: O(n).
     */
    static String angryProfessor(int k, int[] a) {
        int temp = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] <= 0) {
                temp++;
            }

            // We only care up to k.
            if (temp >= k) {
                break;
            }
        }

        return (temp >= k) ? "NO" : "YES";
    }
}