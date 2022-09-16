class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        int[][] dp = new int[m][m];
            
        return dfs(0, 0, n, m, nums, multipliers, dp);
    }
    
    private int dfs(int left, int op, int n, int m, int[] nums, int[] multipliers, int[][] dp) {
        if (op == m) return 0;
        if (dp[left][op] != 0) return dp[left][op];
        int pickLeft = dfs(left + 1, op + 1, n, m, nums, multipliers, dp) + (nums[left] * multipliers[op]);
        int pickRight = dfs(left, op + 1, n, m, nums, multipliers, dp) + (nums[n - (op - left) - 1] * multipliers[op]);
        return dp[left][op] = Math.max(pickLeft, pickRight);
    }
}
