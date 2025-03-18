package Easy;

import java.util.Arrays;

public class ValidPalindrome {
    public static Boolean isPalindrome(String pal) {
        pal = pal.replaceAll("[^/a-zA-Z0-9]", "").toLowerCase();
        return pal.equals(new StringBuilder(pal).reverse().toString().toLowerCase());
    }
    public static Boolean isPalindromeTwo(String pal) {
        String strA = pal.replaceAll("[^/a-zA-Z0-9]", "");

        return false;
    }




    public static void main(String[] args) {
        String pal = "ab_a..";
        System.out.println(isPalindromeTwo(pal));
    }
}
