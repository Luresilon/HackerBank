package BinarySearch.Medium;
//Context 414: Q2

import java.util.Arrays;

public class MaximizeScoreOfNumbersInRanges {

    private static int maxPossibleScore(int[] start, int d) {
        int len = start.length;
        Arrays.sort(start);

        long l = 0, res = 0;
        long r = (long) start[len - 1] + d - start[0];

        while(l <= r) {
            long mid = l + (r - l) / 2;
            if(achievable(start, d, mid)) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return (int) res;
    }

    private static boolean achievable(int[] start, int d, long mid) {
        long prev = start[0];

        for(int i = 1; i < start.length; i++) {
            long next = Math.max(prev + mid, start[i]);

            if(next > (long) start[i] + d) return false;

            prev = next;
            int g = Integer.toBinaryString(10);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] start = {2, 6, 13, 13};
        int d  = 5;

        System.out.println(maxPossibleScore(start, d));
    }
}
