import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prefix = new int[len];
        int[] suffix = new int[len];
        int[] res = new int[len];

        int tmp = 1;
        for(int i = 0; i < len; i++) {
            tmp *= nums[i];
            prefix[i] = tmp;
        }

        tmp = 1;
        for(int i = len - 1; i >= 0; i--) {
            tmp *= nums[i];
            suffix[i] = tmp;
        }

        for(int i = 0; i < len; i++) {
            int pre = (i - 1) < 0 ? 1 : prefix[i - 1];
            int suf = (i + 1) > len  - 1 ? 1 : suffix[i + 1];
            res[i] = pre * suf;
        }

        return res;
    }

    public static int[] productExceptSelfTwo(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;

        int tmpTotal = 1;
        for(int i = 1; i < len; i++) {
            tmpTotal *= nums[i - 1];
            res[i] = tmpTotal;
        }

        tmpTotal = 1;
        for(int j = len - 1; j > 0; j--) {
            tmpTotal *= nums[j];
            res[j - 1] = res[j - 1] * tmpTotal;
        }

        return res;
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelfTwo(A)));
    }
}
