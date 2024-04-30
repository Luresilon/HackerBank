package Hard;

public class TrappingRainWater {

    public static int trappingRainWater(final int[] nums) {
        int tmp = 0;
        int water = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > tmp) tmp = nums[i];
            if (nums[i] < tmp && binarySearch(nums, i, nums[i], tmp)) water += (tmp - nums[i]);
            else tmp = nums[i];
        }
        return water;
    }

    private static boolean binarySearch(int[] arr, int index, int cur, int x) {
        int l = index, r = arr.length - 1;
        if(arr.length == 2) return arr[0] < arr[1];
        if(index + 1 == arr.length) return false;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] >= x && cur < x)
                return true;
            if (arr[m] < x)
                l = m + 1;
            else
                r = m - 1;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height2 = {4,2,3,};
        System.out.println(trappingRainWater(height2));
    }
}
