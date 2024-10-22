package Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Leetcode Problem: 1405
public class LongestHappyStrring {
    public static String longestDiverseString(int a, int b, int c) { //a = 0; b = 1; c = 7;
        int currA = 0, currB = 0, currC = 0;
        int totalIterations = a + b + c;
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < totalIterations; i++) {
            if(
                    (a >= b && a >= c && currA != 2) ||
                    (a > 0 && (currB == 2 || currC == 2))
            ) {
                ans.append('a');
                a--;
                currA++;
                currB = 0;
                currC = 0;
            } else if (
                    (b >= a && b >= c && currB != 2) ||
                    (b > 0 && (currC == 2 || currA == 2))
            ) {
                ans.append('b');
                b--;
                currB++;
                currA = 0;
                currC = 0;
            } else if (
                    (c >= a && c >= b && currC != 2) ||
                    (c > 0 && (currA == 2 || currB == 2))
            ) {
                ans.append('c');
                c--;
                currC++;
                currA = 0;
                currB = 0;
            }
        }

        return ans.toString();
    }
    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        int c = 7;
        double d = Math.ceil(3.0 / 2.0);
        System.out.println(longestDiverseString(a, b, c));
    }
}
