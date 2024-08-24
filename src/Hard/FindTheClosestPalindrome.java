package Hard;

import java.util.Objects;

public class FindTheClosestPalindrome {

    private static String nearestPalindromic(String n) {
        //Brute Force; Struggles with big integers
        int l = Integer.parseInt(String.valueOf(n)) - 1;
        int r = Integer.parseInt(String.valueOf(n)) + 1;

        while(l != intReverse(l) && r != intReverse(r)) {
            l--;
            r++;
        }

        return l == intReverse(l) ? String.valueOf(l) : String.valueOf(r);
    }

    private static String nearestPalindrome2(String n) {
        int len = n.length();
        int num = Integer.parseInt(n) - 1;

        if(len == 1) return String.valueOf(num);
        if(len == 2 && num == 11) return String.valueOf(9);
        if(len == 2 && num + 1 < 16) return String.valueOf(11);
        if(String.valueOf(num).contentEquals(new StringBuilder(String.valueOf(num)).reverse())) return String.valueOf(num);


        String tmp;
        String res;

        if(len % 2 == 0) {
            tmp = n.substring(0, len / 2);
            res = tmp + new StringBuilder(tmp).reverse();
        } else {
            tmp = n.substring(0, len / 2 + 1);
            res = tmp + new StringBuilder(tmp.substring(0, tmp.length() - 1)).reverse();
        }
        return res;
    }
    private static int intReverse(int n) {
        int reverse = 0;
        while(n != 0) {
            int remainder = n % 10;
            reverse = reverse * 10 + remainder;
            n = n / 10;
        }
        return reverse;
    }
    public static void main(String[] args) {
        final String n = "12";
//        System.out.println(nearestPalindromic(n));
        System.out.println(nearestPalindrome2(n));
    }

}
