import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /**
     * O(1) solution -- simpler.
     */
    static int pageCount(int n, int p) {
        // Starting from page 1.
        int start = p / 2;

        // Starting from page n.
        int end = (n / 2) - (p / 2);

        return (start > end) ? end : start;
    }

    /**
     * O(1) solution -- original.
     */
    static int pageCount2(int n, int p) {
        // Base case: page 1.
        if (p == 1) { return 0; }

        // We abuse integer divison.
        int half = n / 2;

        if (p < half) { return (p / 2); }
        else if (p > half) { return half - (p / 2); }

        // Offset + 1 from page 1 always being on its own.
        return (n / (p + 1));
    }
}