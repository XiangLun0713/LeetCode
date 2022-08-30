class Solution {
    public void rotate(int[][] matrix) {
        reverseDiagonally(matrix);
        reverseHorizontally(matrix);
    }
    
    private void reverseHorizontally(int[][] matrix) {
        int numOfRow = matrix.length;
        int numOfCol = matrix[0].length;
        
        for (int i = 0; i < numOfRow; i++) {
            for (int j = 0; j < numOfCol / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][numOfCol - j - 1];
                matrix[i][numOfCol - j - 1] = temp;
            }
        }
    }
    
    private void reverseDiagonally(int[][] matrix) {
        int numOfRow = matrix.length;
        int numOfCol = matrix[0].length;
        
        for (int i = 0; i < numOfRow - 1; i++) {
            for (int j = i + 1; j < numOfCol; j++) {
                if (i == j) continue;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        } 
    }
}
