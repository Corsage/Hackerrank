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
     * Usually when a question has the word "circular",
     * modding is involved.
     *
     * After spending some time doing some examples to
     * try to find some sort of formula, I got this:
     *
     * 1) m + s - 1 -->  We subtract 1, because we give
     *    the candy to the initial person.
     *
     * 2) mod the above result by n --> So we know how
     *    many times it goes around.
     */

    /**
     * Time complexity: O(1).
     */
    static int saveThePrisoner(int n, int m, int s) {
        int temp = m + s - 1;
        return (temp % n == 0) ? n : (temp % n);
    }
}