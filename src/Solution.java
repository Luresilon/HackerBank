public class Solution {
    static int MOD = 1000000007;
    public static int findNumberOfWays(int n_intervals, int n_processes) {
        // Create a 2D array to store the number of ways to schedule processes
        // dp[i][j] represents the number of ways to schedule j processes in i intervals
        int[][] dp = new int[n_intervals + 1][n_processes + 1];

        // Initialize the base cases
        for (int i = 1; i <= n_processes; i++) {
            dp[1][i] = 1;
        }

        // Fill in the dp array using bottom-up approach
        for (int i = 2; i <= n_intervals; i++) {
            for (int j = 1; j <= n_processes; j++) {
                // For each dp[i][j], consider scheduling process k in the first interval
                // dp[i][j] += dp[i-1][k] for all k != j
                for (int k = 1; k <= n_processes; k++) {
                    if (k != j) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
                    }
                }
            }
        }

        // Sum up the ways to schedule n_processes in n_intervals
        int totalWays = 0;
        for (int i = 1; i <= n_processes; i++) {
            totalWays = (totalWays + dp[n_intervals][i]) % MOD;
        }

        return totalWays;
    }

    public static void main(String[] args) {
        int n_intervals = 2;
        int n_processes = 3;
        int result = findNumberOfWays(n_intervals, n_processes);
        System.out.println(result); // Output: 0
    }
}
