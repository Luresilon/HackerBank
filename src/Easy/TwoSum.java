package Easy;

import java.util.Arrays;
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
    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4,-5};
        int target = -8;

        int[] res = isTwoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
