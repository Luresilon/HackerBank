package Medium;

public class ZeroArrayTransformationII {
    public static int minZeroArray(int[] nums, int[][] queries) {
        if(isZeroArray(nums)) return 0;

        for(int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            for(int j = start; j <= end; j++) {
                int val = queries[i][2];
                int curr = nums[j];

                if(curr <= 0) continue;
                if(curr - val < 0) {
                    nums[j] = 0;
                } else {
                    nums[j] = curr - val;
                }
            }

            if(isZeroArray(nums)) return i + 1;
        }

        return -1;
    }

    public static boolean isZeroArray(int[] nums) {
        for(int num : nums) if (num != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        int[][] queries = {{0,0,1},{0,0,1},{0,0,3}};
        System.out.println(minZeroArray(nums, queries));
    }
}
