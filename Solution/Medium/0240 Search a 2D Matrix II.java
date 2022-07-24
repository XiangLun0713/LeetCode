class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int rowPos = 0, colPos = n - 1;
        while (rowPos < m && colPos >= 0) {
            if (matrix[rowPos][colPos] > target) {
                colPos--;
            } else if (matrix[rowPos][colPos] < target) {
                rowPos++;
            } else {
                return true;
            }
        }
        
        return false;
    }
}
