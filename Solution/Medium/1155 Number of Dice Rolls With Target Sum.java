class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        final int MOD = 1000_000_007;
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 1; i <= Math.min(k, target); i++) {
            dp[1][i] = 1;
        }
        for (int row = 2; row <= n; row++) {
            for (int col = 1; col <= target; col++) {
                int val = 0;
                for (int i = 1; i <= k; i++) {
                    if (col - i < 0) continue;
                    val = (val + dp[row - 1][col - i]) % MOD;
                }
                dp[row][col] = val;
            }
        }
        return dp[n][target];
    }
}
