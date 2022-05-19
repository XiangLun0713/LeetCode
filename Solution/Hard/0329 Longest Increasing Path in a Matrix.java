class Solution {
    private int[][] mapping = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        int numOfRow = matrix.length;
        int numOfCol = matrix[0].length;
        int[][] cache = new int[numOfRow][numOfCol];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numOfRow; i++) {
            for (int j = 0; j < numOfCol; j++) {
                max = Math.max(max, findLongestPath(i, j, matrix, cache, numOfRow, numOfCol));
            }
        }
        return max;
    }

    private int findLongestPath(int row, int col, int[][] matrix, int[][] cache, int numOfRow, int numOfCol) {
        int max = 1;
        for (int[] dir : mapping) {
            int count = 1;
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newCol >= 0 && newCol < numOfCol && newRow >= 0 && newRow < numOfRow && matrix[newRow][newCol] > matrix[row][col]) {
                if (cache[newRow][newCol] != 0) {
                    count += cache[newRow][newCol];
                } else {
                    count += findLongestPath(newRow, newCol, matrix, cache, numOfRow, numOfCol);
                }
                max = Math.max(max, count);
            }
        }
        cache[row][col] = max;
        return max;
    }
}
