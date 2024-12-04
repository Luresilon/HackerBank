package Medium;

import java.util.*;
import java.util.function.Function;

//Leetcode Problem: 2501
public class LongestSquareStreakInAnArray {

    public static int longestSquareStreak(int[] nums) {
        int longestStreak = 0;

        Set<Integer> s = new HashSet<>();
        for(int num: nums) s.add(num);

        for(int num: nums) {
            int currentStreak = 0;
            long current = num;
            double sqr = Math.pow(current, 0.5);

            while(s.contains((int) current)) {
                currentStreak++;

                if(current * current > 1e5) break;
                current += current;
            }
            longestStreak = Math.max(longestStreak, currentStreak);
        }

        return longestStreak == 1 ? -1 : longestStreak;
    }
    public static void main(String[] args) {
        int[] nums = {4, 3, 6, 16, 8, 2};
        int[] nums2 = {2,3,5,6,7};
        System.out.println(Math.pow(7, 0.5));
        System.out.println(longestSquareStreak(nums2));
    }
}
