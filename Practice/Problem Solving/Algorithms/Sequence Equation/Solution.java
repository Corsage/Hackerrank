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
     * The wording is a little confusing but essentially
     * the function is y = f(f(x)), where x is the
     * number that goes into the new array, and y
     * is the resultant index.
     */

    /**
     * Time complexity: O(n).
     */
    static int[] permutationEquation(int[] p) {
        int[] results = new int[p.length];

        for (int i = 0; i < p.length; i++) {
            results[p[p[i] - 1] - 1] = i + 1;
        }

        return results;
    }

}