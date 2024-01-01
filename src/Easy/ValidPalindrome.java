package Easy;

public class ValidPalindrome {
    public static Boolean isPalindrome(String pal) {
        pal = pal.replaceAll("[^/a-zA-Z0-9]", "").toLowerCase();
        System.out.println(pal);
        return pal.equals(new StringBuilder(pal).reverse().toString().toLowerCase());
    }

    public static void main(String[] args) {
        String pal = "ab_a..";
        System.out.println(isPalindrome(pal));
    }
}
