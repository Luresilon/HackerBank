package Easy;

import java.util.Arrays;

public class BinarySearch {

    public static int binarySearch(int[] nums, int target) {
        if(nums.length == 0 || target == null) return -1;
        Arrays.sort(nums);

        int lo = 0;
        int hi = nums.length - 1;

        while(lo < hi) {
            int mid = lo + (int) (Math.floor(hi - lo + 1) / 2);
            if(target < nums[mid]) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return target == nums[lo] ? lo : -1;
    }
    public static void main(String[] args) {
//         int[] nums = {1, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
         int[] randomNums = { 13, 5, 7, 11, 23, 17, 19, 1, 3,  29, 31};
         int target = 19;
         System.out.println(binarySearch(randomNums, target));
    }
}
