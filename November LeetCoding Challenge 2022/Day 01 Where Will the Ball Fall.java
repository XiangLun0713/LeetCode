class Solution {
    public int[] findBall(int[][] grid) {
        int numOfRow = grid.length, numOfCol = grid[0].length;
        int[] result = new int[numOfCol];
        
        for (int col = 0; col < numOfCol; col++) {
            int out = col;
            for (int row = 0; row < numOfRow; row++) {
                int dir = grid[row][out];
                int newOut = out + dir;
                if (newOut < 0 || newOut >= numOfCol || dir != grid[row][newOut]) {
                    out = -1;
                    break;
                }
                out = newOut;
            }
            result[col] = out;
        }
        return result;
    }
}
