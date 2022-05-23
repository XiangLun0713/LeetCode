class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int numOfZero = 0;
            int numOfOne = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') { 
                    numOfZero++;
                } else {
                    numOfOne++;
                }    
            }
            
            for (int i = m; i >= numOfZero; i--) {
                for (int j = n; j >= numOfOne; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - numOfZero][j - numOfOne] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
