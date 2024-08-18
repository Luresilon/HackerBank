package Medium;

public class BinarySearch {
    // Example: 5 ? 2
    // Division [/]: 2.5 = 2
    // Modulo [%]: 2.5 = 1 (because 2 can fit into 5 twice, equalling 4; 5-4 = 1)
    // Math.floor(): 2.5 = 2 (rounds up to the bottom; if negative, still rounds up to the bottom, so -2.5 = -3)
    // math.ceil(): 2.5 = 3 (rounds up to the top)

    protected static int binarySearch(final int[] nums, final int target) {
        int hi = nums.length - 1;
        int lo = 0;

        while(lo < hi) {
            int mid = lo + (int) Math.floor( (double) (hi - lo + 1) / 2);
            if(nums[mid] > target) hi = mid - 1;
            else lo = mid;
        }
        return nums[lo] == target ? lo : -1;
    }


    protected static int binarySearch2(final int[] nums, final int target) {
        int hi = nums.length - 1;
        int lo = 0;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) lo = mid + 1;
            if (nums[mid] > target) hi = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-3, -1, 1, 5, 7, 13};
        int target = 5;

        System.out.println(binarySearch(nums, target));
        System.out.println(binarySearch2(nums, target));

        System.out.println(5 % 2);
        System.out.println(5 / 2);
        System.out.println(nums[5 / 2]);
        System.out.println(3.72 % 2);
        System.out.println(3.72 / 2);
    }
}
