package Medium;
//Leetcode Problem: 2938

public class SeparateBlackAndWhiteBalls {

    public static long minimumSteps(String s) {
        long totalSwaps = 0;
        int blackBallCount = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') totalSwaps += (long) blackBallCount;
            else blackBallCount++;
        }

        return totalSwaps;
    }
    public static void main(String[] args) {
        String s = "0101101";

        System.out.println(minimumSteps(s));
    }
}
