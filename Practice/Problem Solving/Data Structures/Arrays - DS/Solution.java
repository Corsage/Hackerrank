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
     * Very simple question -- just reverse the array.
     */

    /**
     * Time complexity: O(n).
    */
    static int[] reverseArray(int[] a) {
        int length = a.length;

        int[] reverse = new int[length];

        for (int i = 0; i < length; i++) {
            reverse[i] = a[length - i - 1];
        }

        return reverse;
    }
}