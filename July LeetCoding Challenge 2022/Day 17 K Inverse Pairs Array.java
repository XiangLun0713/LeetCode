class Solution {
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        int mod = 1000_000_007;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < k + 1; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {   
                    int val = (dp[i - 1][j] + mod - ((j - i) >= 0 ? dp[i - 1][j - i] : 0)) % mod;
                    dp[i][j] = (dp[i][j - 1] + val) % mod;
                }
            }
        }
        return ((dp[n][k] + mod - (k > 0 ? dp[n][k - 1] : 0)) % mod);
    }
}
