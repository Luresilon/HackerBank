package Easy;

import java.util.Collections;
import java.util.Stack;

public class MinimumStringLengthAfterRemovingSubstrings {

//    public static int minLenght(String s) {
//        int len = s.length();
//        if(len == 1) return 1;
//        if(len == 2 && !s.equals("AB") && !s.equals("CD")) return 2;
//
//        while(s.contains("AB") || s.contains("CD")) {
//            for(int i = 0; i < len - 1; i++) {
//                char[] strList = s.toCharArray();
//
//                String condition = (strList[i] + "" + strList[i + 1]);
//
//                if(condition.equals("AB") || condition.equals("CD")) {
//                    strList[i] = ' ';
//                    strList[i + 1] = ' ';
//                    s = stringBuilder(strList);
//
//                    break;
//                }
//            }
//        }
//        System.out.println(s);
//        return s.length();
//    }

//    public static int minLenght(String s) {
//        int len = s.length();
//
//        if(len == 1) return 1;
//        if(len == 2 && !s.equals("AB") && !s.equals("CD")) return 2;
//
//        StringBuilder stringBuilder = new StringBuilder(s);
//        int index = Math.max(s.indexOf("AB"), s.indexOf("CD"));
//
//        if(index != -1) stringBuilder.replace(index, index + 2, "");
//        else return stringBuilder.toString().length();
//
//        return minLenght(stringBuilder.toString());
//    }

    public static int minLength(String s) {
         Stack<Character> stack = new Stack<>();

         char[] chars = s.toCharArray();
         char cur_char;

         for(int i = 0; i < chars.length; i++) {
             cur_char = chars[i];

             if(stack.isEmpty()) {
                 stack.push(cur_char);
                 continue;
             }

             if(cur_char == 'B' && stack.peek() == 'A') stack.pop();
             else if(cur_char == 'D' && stack.peek() == 'C') stack.pop();
             else stack.add(cur_char);
         }
         return stack.size();
    }
    public static void main(String[] args) {
        String s = "ABFCACDB";

//        System.out.println(s.indexOf("CD"));

        System.out.println(minLength(s));
    }
}
