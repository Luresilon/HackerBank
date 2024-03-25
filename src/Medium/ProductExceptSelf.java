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
        System.out.println(Arrays.toString(prefix));

        for(int i = n - 1; i >= 0; i--) {
            suffix[i] = sufProduct;
            sufProduct *= nums[i];
        }
        System.out.println(Arrays.toString(suffix));


        for(int i = 0; i < n; i++) {
            res[i] = suffix[i] * prefix[i];
        }
        return res;
    }







//    public static int[] func(int[] nums) {
//        int n = nums.length;
//        int[] res = new int[n];
//
//        for(int i = 0; i < n; i++) {
//            int[] tmp = nums;
//            tmp[i] = 1;
//            int tmpValue = 1;
//            Arrays.stream(nums).forEach(t);
//        }
//    }




    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
