package Medium;
//Leetcode Problem: 1963

public class MinimumNumberOfSwapsToMakeTheStringBalanced {

    public static int minSwaps(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int openBrackets = 0;
        int counter = 0;

        for(int i = 0; i < len; i++) {
            if(chars[i] == '[') openBrackets++;
            else openBrackets--;
            if(openBrackets < 0) {
                chars[s.lastIndexOf('[')] = ']';
                chars[i] = '[';
                openBrackets += 2;
                counter++;
            }
        }
        return counter;
    }
    public static void main(String[] args) {
        String s = "]]][[[";
        System.out.println(s.lastIndexOf('['));
        //[]][[]
        //[][][]
        System.out.println(minSwaps(s));
    }
}
