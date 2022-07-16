class Solution {
    private int[][][] dp;
    private int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int[m][n][maxMove + 1];
        for (int[][] temp : dp) for (int[] temp1 : temp) Arrays.fill(temp1, -1);
        return dfs(m, n, maxMove, startRow, startColumn);
    }

    private int dfs(int m, int n, int maxMove, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n) return 1;
        if (maxMove == 0) return 0;
        if (dp[row][col][maxMove] >= 0) return dp[row][col][maxMove];

        int count = 0;
        for (int[] dir : directions) {
            count = (count + dfs(m, n, maxMove - 1, row + dir[0], col + dir[1])) % 1000_000_007;
        }
        dp[row][col][maxMove] = count % 1000_000_007;
        
        return dp[row][col][maxMove];
    }
}
