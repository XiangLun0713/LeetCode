class NumMatrix {
    private int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        int[][] sumMatrix = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i < sumMatrix.length; i++) {
            for (int j = 1; j < sumMatrix[0].length; j++) {
                sumMatrix[i][j] = matrix[i - 1][j - 1] + sumMatrix[i - 1][j] + sumMatrix[i][j - 1] - sumMatrix[i - 1][j - 1];
            }
        }
        this.sumMatrix = sumMatrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumMatrix[row2 + 1][col2 + 1] - sumMatrix[row2 + 1][col1] - sumMatrix[row1][col2 + 1] + sumMatrix[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
