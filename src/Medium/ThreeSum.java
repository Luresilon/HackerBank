package Medium;

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        int len = nums.length;
        Arrays.sort(nums);

        for(int i = 0; i < len - 2; i++) {
            int j = i + 1;
            int k = len - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) set.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                else if(sum > 0) k--;
                else j++;
            }
        }

        return new ArrayList<>(set);
    }
    public static void main(String[] args) {
        int[] list = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(list));
    }
}
