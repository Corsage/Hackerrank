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
     * A person can bribe at most two others.
     * _ _ x _ _ is at most where x can go
     * from it's initial position.
     * 
     * We just need to count the number of
     * swaps we need to make to sort the
     * list again.
     * 
     * Since at most an element can 2 left
     * or 2 right from the list. We could
     * probably use insertion sort since
     * it's a nearly sorted list (?)
     */

    /**
     * Time complexity: A bit above O(n).
     */
    static void minimumBribes(int[] q) {
        int swaps = 0;

        for (int i = 0; i < q.length; i++) {
            int key = q[i];
            int j = i - 1;

            int diff = q[i] - i - 1;
            if (diff > 2) {
                System.out.println("Too chaotic");
                return;
            }

            while (j >= 0 && q[j] > key) {
                q[j + 1] = q[j];
                j = j - 1;
                swaps++;
            }

            q[j + 1] = key;
        }

        System.out.println(swaps);
    }
}