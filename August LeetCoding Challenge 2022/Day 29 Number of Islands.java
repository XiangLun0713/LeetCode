class Solution {
    public int numIslands(char[][] grid) {
        int numOfRow = grid.length;
        int numOfCol = grid[0].length;
        int count = 0;
        
        for (int i = 0; i < numOfRow; i++) {
            for (int j = 0; j < numOfCol; j++) {
                if (grid[i][j] == '1') {
                    fillAdjacentLand(grid, i, j, numOfRow, numOfCol);
                    count++;
                }
            }
        } 
        
        return count;
    }
    private void fillAdjacentLand(char[][] grid, int row, int col, int numOfRow, int numOfCol) {     
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        grid[row][col] = '0';
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow >= 0 && newRow < numOfRow && newCol >= 0 && newCol < numOfCol && grid[newRow][newCol] == '1') {
                fillAdjacentLand(grid, newRow, newCol,numOfRow, numOfCol);
            }
        }    
    }
}
