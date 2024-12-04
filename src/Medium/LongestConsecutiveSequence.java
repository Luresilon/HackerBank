package Medium;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

//Leetcode problem: 128
public class LongestConsecutiveSequence {


    public static int longestConsecutive(int[] arr) {
        //O(N) solution
        if(arr.length == 0) return 0;

        HashSet<Integer> set = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toCollection(HashSet::new));
        int longestStreak = 1;

        for(int i = 0; i < set.size(); i++) {
            int currStreak = 1;
            int curr = arr[i];

            if(!set.contains(curr - 1)) {
                while(set.contains(curr + 1)) {
                    curr++;
                    currStreak++;
                }
            }
            longestStreak = Math.max(currStreak, longestStreak);
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};

        System.out.println(longestConsecutive(arr));
    }
}
