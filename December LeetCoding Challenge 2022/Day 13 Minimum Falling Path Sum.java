class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int numOfRow = matrix.length;
        int numOfCol = matrix[0].length;
        int[][] dp = new int[numOfRow][numOfCol];
        dp[0] = matrix[0].clone();
        for (int row = 1; row < numOfRow; row++) {
            for (int col = 0; col < numOfCol; col++) {
                int curr = matrix[row][col];
                int min = curr + dp[row - 1][col];
                if (col > 0) {
                    min = Math.min(min, curr + dp[row - 1][col - 1]);
                }
                if (col < numOfCol - 1) {
                    min = Math.min(min, curr + dp[row - 1][col + 1]);
                }
                dp[row][col] = min;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int col = 0; col < numOfCol; col++) {
            min = Math.min(dp[numOfRow- 1][col], min);
        }
        return min;
    }
}
