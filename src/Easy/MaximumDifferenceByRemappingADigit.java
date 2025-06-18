package Easy;

import java.util.Arrays;

public class MaximumDifferenceByRemappingADigit {

    public static int minMaxDifference(int num) {
        final String str = Integer.toString(num);
        int max = num;
        int min = Integer.parseInt(str.replace(str.toCharArray()[0], '0'));

        for(char chr: str.toCharArray()) {
            if(chr != '9') {
                max = Integer.parseInt(str.replace(chr, '9'));
                break;
            }
        }

        return max - min;
    }
    public static void main(String[] args) {
        int num = 99;
        System.out.println(minMaxDifference(num));
    }
}
