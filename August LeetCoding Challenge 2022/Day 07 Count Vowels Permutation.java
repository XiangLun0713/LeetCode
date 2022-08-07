class Solution {
    public int countVowelPermutation(int n) {
        final int MOD = 1000_000_007;
        
        // dp[i][j] indicates the number of permutation where the string is length i and the last char is j
        long[][] dp = new long[n + 1][5];
        Arrays.fill(dp[1], 1);
        
        for (int i = 2; i < n + 1; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % MOD;
            dp[i][3] = dp[i - 1][2];
            dp[i][4] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
        }
        
        long sum = 0;
        for (int i = 0; i < 5; i++) {
            sum = (sum + dp[n][i]) % MOD;
        }
        
        return (int) sum;
    }
}
