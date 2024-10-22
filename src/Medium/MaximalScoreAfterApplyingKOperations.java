package Medium;
//Leetcode Problem: 2530

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaximalScoreAfterApplyingKOperations {

    public static long maxElements(int[] nums, int k) {
        if(nums.length == 1) return nums[0];

        long res = 0;
        int maxElement;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i: nums) pq.add(i);

        while(k-- > 0) {
            if(!pq.isEmpty()) maxElement = pq.poll();
            else return res;

            res += maxElement;
            pq.add((int) Math.ceil((double) maxElement / 3));
        }

        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1, 10, 3, 3, 3};
        int k = 3;

        System.out.println(maxElements(nums, k));
    }
}
