class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();

        for (int row = 0; row < l1; row++) {
            for (int col = 0; col < l2; col++) {
                if (s1[row] == s2[col]) {
                    dp[row + 1][col + 1] = dp[row][col] + 1;
                } else {
                    dp[row + 1][col + 1] = Math.max(dp[row][col + 1], dp[row + 1][col]);
                }
            }
        }
        return l1 + l2 - 2 * dp[l1][l2];
    }
}
