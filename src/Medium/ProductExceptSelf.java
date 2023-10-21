package Medium;

import java.util.Arrays;
import java.util.LinkedList;

public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        var n = nums.length;
        var prefix = new int[n];
        var suffix = new int[n];
        var res = new int[n];

        var preProduct = 1;
        var sufProduct = 1;

        for(int i = 0; i < n; i++) {
            prefix[i] = preProduct;
            preProduct *= nums[i];
        }

        for(int i = n - 1; i >= 0; i--) {
            suffix[i] = sufProduct;
            sufProduct *= nums[i];
        }

        for(int i = 0; i < n; i++) {
            res[i] = suffix[i] * prefix[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
