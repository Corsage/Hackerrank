import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    /**
     * Initial logic:
     * Just need to calculate displacement between the cats and the mouse.
     */

    /**
     * Time complexity: O(1).
     * Space complexity: O(1).
     */
    static string catAndMouse(int x, int y, int z) {

        int distanceA = Math.abs(x - z);
        int distanceB = Math.abs(y - z);

        if (distanceA == distanceB) {
            return "Mouse C";
        } else if (distanceA < distanceB) {
            return "Cat A";
        } else {
            return "Cat B";
        }
    }
}