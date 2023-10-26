package JobCodeChallenges;

public class ClosestToZero {
    public static void computeClosestToZero(int[] ts) {
        int close = Integer.MAX_VALUE;

        for(var v1: ts) {
            int tmp = v1;
            if(close > tmp) {
                close = tmp;
            }
        }
    }
}
