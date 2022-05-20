// Using Dynamic Programming method
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        Arrays.fill(cache[m - 1], 1);
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (j == n - 1) {
                    cache[i][j] = 1;
                } else {
                    cache[i][j] = cache[i + 1][j] + cache[i][j + 1];
                }
            }
        }
        return cache[0][0];
    }
}
