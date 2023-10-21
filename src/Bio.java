import java.util.Arrays;
import java.util.List;

public class Bio {
    public static int countIntervals(int n, List<Integer> allergic, List<Integer> poisonous) {
        boolean[][] coexist = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                coexist[i][j] = true;
            }
        }
        for (int i = 0; i < allergic.size(); i++) {
            coexist[allergic.get(i)][poisonous.get(i)] = false;
            coexist[poisonous.get(i)][allergic.get(i)] = false;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            boolean valid = true;
            for (int j = i; j <= n && valid; j++) {
                for (int k = i; k <= j && valid; k++) {
                    if (!coexist[k][j]) {
                        valid = false;
                    }
                }
                if (valid) {
                    count++;
                }
            }
        }
        return count;
    }



    public static void main(String[] args) {
        int n = 4;
        List<Integer> allergic = Arrays.asList(1, 2);
        List<Integer> poisonous = Arrays.asList(3, 4);
        int result = countIntervals(n, allergic, poisonous);
        System.out.println("Result: " + result);
    }

}
