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
     * If we are rotating by x each time, we can simply
     * go up by x and keep swapping until we are done.
     * 
     * Simply modding by the array size to wrap around.
     */

    /**
     * Time complexity: O(n) -- goes thru all n elements.
     * Space complexity: O(n) -- we make an array size n.
     */
    static int[] rotLeft(int[] a, int d) {
        int[] arr = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            arr[(i - d + a.length) % a.length] = a[i]; 
        }

        return arr;
    }
}