package JobCodeChallenges;

import java.util.List;

public class SubArrayProducts {
    public static long countSubArrays (List<Integer> numbers, int k) {
        if(k <= 1) {
            return 0;
        }

        int count = 0;
        int product = 0;
        int num = 0;

        for(int i = 0; i < numbers.size(); i++) {
            while(product >= numbers.get(num)) {
                num++;
            }
            count += (i - num + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 3, 4);
        System.out.println(countSubArrays(numbers, 6));
    }
}
