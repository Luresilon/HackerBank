package Medium;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TwoSumII {

    public static int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; i++) {
            int tmp = target - numbers[i];
            if(Objects.equals(numbers, tmp)) {
                return new int[]{i, List.of(numbers).indexOf(tmp)};
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }
}
