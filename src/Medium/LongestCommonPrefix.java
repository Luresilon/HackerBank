package Medium;

import java.util.*;

public class LongestCommonPrefix {

    private static int longestCommonPrefix(int[] arr1, int[] arr2) {
        int ans = 0;

        for(int i = 0; i < arr1.length; i++) {
            for(int j = 0; j < arr2.length; j++) {
                char[] str1 = Integer.toString(arr1[i]).toCharArray();
                char[] str2 = Integer.toString(arr2[j]).toCharArray();
                int counter = 0;

                for(int k = 0; k < Math.min(str1.length, str2.length); k++) {
                    if(str1[k] != str2[k]) break;
                    counter++;
                }
                ans = Math.max(ans, counter);
            }
        }
        return ans;
    }

    private static int optimisedLongestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> prefixes = new HashSet<>();
        int ans = 0;

        for(int num: arr1) {
            while(num > 0) {
                prefixes.add(num);
                num /= 10;
            }
        }

        for(int num: arr2) {
            while(num > 0) {
                if(prefixes.contains(num)) {
                    ans = Math.max(ans, String.valueOf(num).length());
                    break;
                }
                num /= 10;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr1 = {1, 10, 100};
        int[] arr2 = {1000};
//        int[] arr1= {1, 2, 3};
//        int[] arr2 = {4, 4, 4};

        System.out.println(optimisedLongestCommonPrefix(arr1, arr2));
//        System.out.println(234 / 10);
    }
}
