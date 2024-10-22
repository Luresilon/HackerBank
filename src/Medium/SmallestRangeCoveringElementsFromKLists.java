package Medium;

import java.util.Comparator;
import java.util.PriorityQueue;

//Leetcode Problem: 632
public class SmallestRangeCoveringElementsFromKLists {

    public static int[] smallestRange(int[][] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int maxVal = Integer.MIN_VALUE;
        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++) {
            pq.offer(new int[] {nums[i][0], i, 0});
        }

        return new int[]{};
    }
    public static void main(String[] args) {
        int[][] AA = {{4, 10, 15, 24, 26}, {0, 9, 12, 20}, {5, 18, 22, 30}};

        System.out.println(smallestRange(AA));
    }
}
