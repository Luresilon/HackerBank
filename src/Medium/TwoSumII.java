package Medium;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TwoSumII {

    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while(numbers[i] + numbers[j] != target) {
            if(numbers[i] + numbers[j] >= target) j--;
            else i++;
        }
        return new int[] {i + 1, j + 1};
    }

    public static void main(String[] args) {
        int[] numbers = {-1, 0};
        int target = -1;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }
}
