import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    /**
     * O(n) solution -- using only primitives.
     */
    static int countingValleys(int n, String s) {
        int valleys = 0;
        int topography = 0; // Sea-level is 0.

        for (int i = 0; i < n; i++) {
            char temp = s.charAt(i);

            if (temp == 'D') {
                if (topography-- == 0) {
                    valleys++;
                }
            } else {
                topography++;
            }
        }
        
        return valleys;
    }
}