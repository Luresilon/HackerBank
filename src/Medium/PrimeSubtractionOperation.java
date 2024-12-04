package Medium;

//Leetcode problem: 2601

import java.util.Arrays;

public class PrimeSubtractionOperation {
    public static boolean primeSubOperation(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            if(currNum == 1) return false;

            for(int j = currNum - 1; j >= 2; j--) {
                if(isPrime(j)) {
                    nums[i] = currNum - j;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        return false;
    }

    public static boolean isPrime(int n) {
        if(n % 2 == 0) return false;

        for(int i = 3; i * i <= n; i += 2) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] nums = {4, 9, 6, 10};
        System.out.println(primeSubOperation(nums));
    }
}
