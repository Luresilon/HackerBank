package Easy;

import java.util.*;

public class validAnagram {

    public static boolean isAnagram(String s, String t) {
        if(t.length() != s.length()) return false;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);
    }
    public static void main(String[] args) {
        String s = "anagrasm";
        String t = "nagaram";

        boolean isDuplicate = isAnagram(s, t);
        System.out.println(isDuplicate);
    }
}
