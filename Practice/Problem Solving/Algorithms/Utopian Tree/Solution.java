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
     * The height of the utopian tree at a cycle
     * relies on the height from the previous.
     * 
     * Most likely a recursive function.
     * 
     * For f(n) for n cycles,
     *  if n is odd -> return 2 * f(n - 1)
     *  if n is even -> return 1 + f(n - 1)
     * 
     * We have a base case, n == 0 return 1.
     */

    /**
     * Time complexity: O(n) -- n recursive calls.
     */
    static int utopianTree(int n) {
        if (n == 0) {
            return 1;
        } else if (n % 2 == 0) {
            return 1 + utopianTree(n - 1);
        }

        return 2 * utopianTree(n - 1);
    }
}