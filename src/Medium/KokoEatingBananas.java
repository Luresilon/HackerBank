package Medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

public class KokoEatingBananas {
    protected static int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = Arrays.stream(piles).max().getAsInt();

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (canEatAll(piles, mid, h)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private static boolean canEatAll(int[] piles, int k, int h) {
        int hours = 0;
        for (int pile : piles) {
            hours += (int) Math.ceil((double) pile / k);
        }
        return hours <= h;
    }

    protected static int binarySearch(int[] piles, int h) {
        Arrays.sort(piles);

        int lo = 0;
        int hi = piles.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (piles[mid] == h) return mid;
            else if (piles[mid] < h) lo = mid + 1;
            else hi = mid - 1;
        }
        return piles[lo] == h ? lo : -1;
    }

    protected static int binarySearchTwo(int[] piles, int target) {
        int lo = 0;
        int hi = piles.length - 1;

        while(lo < hi) {
            int mid = lo + (int) Math.floor( (double) (hi - lo + 1) / 2);
            if(piles[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return piles[lo] == target ? lo : -1;
    }
    public static void main(String[] args) throws NoSuchElementException {
        int[] piles = {805306368,805306368,805306368};
        Arrays.sort(piles);
        int hours = 1000000000;
        System.out.println(minEatingSpeed(piles, hours));
//        System.out.println(checker(4, piles, 8));
    }
}
