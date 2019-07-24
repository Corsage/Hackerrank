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
     * h contains all the heights a-z.
     * 
     * Need to match each letter in the word
     * to their respective index in h.
     * 
     * Then just multiply highest height by word length.
     */

     /**
      * Time complexity: O(n).
      */
    static int designerPdfViewer(int[] h, String word) {
        int height = 0;

        for (int i = 0; i < word.length(); i++) {
            // 97 is the ASCII value for 'a'.
            // We use this to offset the array.
            int temp = h[((int) word.charAt(i) - 97)];

            if (temp > height) {
                height = temp;
            }
        }

        return (height * word.length());
    }
}