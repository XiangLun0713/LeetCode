class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int numOfRow = matrix.length;
        int numOfCol = matrix[0].length;
        for (int col = 0; col < numOfCol - 1; col++) {
            if (!isValidDiagonal(matrix, 0, col, matrix[0][col], numOfRow, numOfCol)) return false;
        }
        for (int row = 1; row < numOfRow - 1; row++) {
            if (!isValidDiagonal(matrix, row, 0, matrix[row][0], numOfRow, numOfCol)) return false;
        }
        return true;
    }
    private boolean isValidDiagonal(int[][] matrix, int row, int col, int target, int numOfRow, int numOfCol) {
        while (row < numOfRow && col < numOfCol) {
            if (matrix[row][col] != target) return false;
            row++;
            col++;
        }
        return true;
    }
}
