package Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum {

    public static int[] isTwoSum(int[] nums, int target) {
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(nums[i]+nums[j]==target) return new int[] {i,j};
                if(nums[n-i-1]+nums[n-j-1]==target) return new int[] {n-j-1,n-i-1};
            }
        }
        return new int[] {-1,-1};
    }

    private static int[] optimisedIsTwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> sums = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];

            if(sums.containsKey(nums[i])) {
                return new int[]{sums.get(nums[i]), i};
            }
            sums.put(target - nums[i], i);
        }
        return new int[] {};
    }
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] res = optimisedIsTwoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
