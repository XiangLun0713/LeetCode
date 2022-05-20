class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;
        
        int[][] cache = new int[m + 1][n + 1];
        cache[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) continue;
                cache[i][j] = (obstacleGrid[i][j] == 1) ? 0 : cache[i + 1][j] + cache[i][j + 1];
            }
        }
        return cache[0][0];
    }
}
