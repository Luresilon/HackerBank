package DynamicProgramming.Easy;

import java.util.HashMap;

public class MinimumCoins {
    private static final HashMap<Integer, Integer> dp = new HashMap<>();
    private static int minIgnoreNone(Integer a, Integer b) {
        if(a == null) return b;
        if(b == null) return a;
        return Math.min(a, b);
    }
    private static Integer minimumCoins(final int m, final int[] coins) {
        if(dp.containsKey(m)) return dp.get(m);

        Integer answer;

        if(m == 0) answer = 0;
        else {
            answer = null;
            for(int coin: coins) {
                int subProblem = m - coin;
                if (subProblem < 0) continue;
                answer = minIgnoreNone(answer, minimumCoins(subProblem, coins) + 1);
            }
        }
        dp.put(m, answer);
        return answer;
    }
    public static void main(String[] args) {
        final int[] coins = {5, 4, 1};
        final int m = 13;

        System.out.println(minimumCoins(m, coins));
    }
}
