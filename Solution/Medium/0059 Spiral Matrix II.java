class Solution {
    public int[][] generateMatrix(int n) {
        int[][] spiralMatrix = new int[n][n];
        int num = 1;
        for (int i = 0; i < n; i++) {
            // fill left
            for (int j = i; j < n - i; j++) {
                spiralMatrix[i][j] = num++;
            }
            // fill down
            for (int j = i + 1; j < n - i - 1; j++) {
                spiralMatrix[j][n - 1 - i] = num++;
            }
            // fill right
            for (int j = n - 1 - i; j >= i + 1; j--) {
                spiralMatrix[n - 1 - i][j] = num++;
            }
            // fill up
            for (int j = n - 1 - i; j >= i + 1; j--) {
                spiralMatrix[j][i] = num++;
            }
        }
        return spiralMatrix;
    }
}
