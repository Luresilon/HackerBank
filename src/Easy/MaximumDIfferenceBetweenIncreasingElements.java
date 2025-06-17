package Easy;

import java.util.*;

public class MaximumDIfferenceBetweenIncreasingElements {

    public static int Solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(); //key = num, value = index

        for(int i = 0; i < nums.length; i++) map.put(nums[i], i);

        int l = 0;
        int r = map.size() - 1;

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());

        int maxDiff = -1;

        for (int i = 0; i < entries.size(); i++) {
            for (int j = entries.size() - 1; j > i; j--) {
                int lowNum = entries.get(i).getKey();
                int lowIndex = entries.get(i).getValue();

                int highNum = entries.get(j).getKey();
                int highIndex = entries.get(j).getValue();

                if (lowIndex < highIndex) {
                    maxDiff = Math.max(maxDiff, highNum - lowNum);
                    break;
                }
            }
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 1, 4, 2, 6, 10};
        System.out.println(Solution(nums));
    }
}
