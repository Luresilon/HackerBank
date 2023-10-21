import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();

        return IntStream.range(0, nums.length)
                .filter(i -> {
                    int complement = target - nums[i];
                    if (numToIndex.containsKey(complement)) {
                        return true;
                    }
                    numToIndex.put(nums[i], i);
                    return false;
                })
                .mapToObj(i -> new int[]{numToIndex.get(target - nums[i]), i})
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No solution found"));
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println(Arrays.toString(twoSum(nums1, target1))); // [0, 1]

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.println(Arrays.toString(twoSum(nums2, target2))); // [1, 2]

        int[] nums3 = {3, 3};
        int target3 = 6;
        System.out.println(Arrays.toString(twoSum(nums3, target3))); // [0, 1]
    }
}
