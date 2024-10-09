package Medium;

public class MinimumAddToMakeParenthesesValid {

    public static int minAddToMakeValid(String s) {
        int counter = 0;
        int open = 0;

        for(char chr: s.toCharArray()) {
            if(chr == '(') open++;
            else {
                if(open > 0) open--;
                else counter++;
            }
        }

        return counter + open;
    }
    public static void main(String[] args) {
        String s = "()))((";

        System.out.println(minAddToMakeValid(s));
    }
}
