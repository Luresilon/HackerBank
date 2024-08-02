package Medium;

public class BinarySearch {

    protected static int binarySearch(final int[] nums, final int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while(lo < hi) {
            int mid = lo + (int) Math.floor( (double) (hi - lo + 1) / 2);
            if(target < nums[mid]) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }

        return target == nums[lo] ? lo : -1;
    }

    public static void main(String[] args) {
        int[] nums = {-3, -1, 1, 5, 7, 13};
        int target = -3;

        System.out.println(binarySearch(nums, target));
    }
}
