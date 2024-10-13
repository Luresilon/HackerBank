package Medium;
//LeetCode problem: 962

import java.util.Stack;

public class MaximumWidthRamp {

    public static int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            if(stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        int maxWidth = 0;

        for(int j = n - 1; j >= 0; j--) {
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                maxWidth = Math.max(maxWidth, j - stack.pop());
            }
        }

        System.out.println(stack);
        return maxWidth;
    }
    public static void main(String[] args) {
        int[] nums = {2, 2, 1};

        System.out.println(maxWidthRamp(nums));
    }
}