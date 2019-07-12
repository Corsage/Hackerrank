import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    /**
     * Time Complexity: O(n).
     */

    static int sockMerchant(int n, int[] ar) {
        int pairs = 0;

        // Why HashSet?
        // Don't add duplicate values.
        // Don't care about order.
        Set<Integer> colors = new HashSet<>();

        for (int i = 0; i < n; i++) {
            // Time complexity of contain is O(1).
            if (!colors.contains(ar[i])) { 
                // Time complexity of add is O(1).
                colors.add(ar[i]);
            } else {
                pairs++;
                // Time complexity of remove is O(1).
                colors.remove(ar[i]);
            }
        }

        return pairs;
    }
}