package Medium;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountNumberOfMaximumBitwiseORSubsets {

    public static int countMaxOrSubsets(int[] nums) {
        if(nums.length == 1) return 1;

        int maxBitwise = arrayOrBitwise(nums);
        List<List<Integer>> res = new ArrayList<>();

        generateSubsets(nums, 0, new ArrayList<>(), res, maxBitwise);

        return res.size();
    }
    public static int arrayOrBitwise(int[] arr) {
        int maxBitwise = 0;
        for (int num : arr) maxBitwise |= num;
        return maxBitwise;
    }
    public static void generateSubsets(int[] nums, int index, List<Integer> currentSubset, List<List<Integer>> res, int maxBitwise) {
        if (index == nums.length) {
            int subsetOr = 0;
            for (int num : currentSubset) subsetOr |= num;

            if (subsetOr == maxBitwise) res.add(new ArrayList<>(currentSubset));

            return;
        }

        currentSubset.add(nums[index]);
        generateSubsets(nums, index + 1, currentSubset, res, maxBitwise);

        currentSubset.remove(currentSubset.size() - 1);
        generateSubsets(nums, index + 1, currentSubset, res, maxBitwise);
    }
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5};

        System.out.println(countMaxOrSubsets(nums));
    }
}
