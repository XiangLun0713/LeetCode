class Solution {
    private int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, countIslandArea(grid, i, j));
                }
            }
        }
        return max;
    }
    
    private int countIslandArea(int[][] grid, int row, int col){
        int count = 1;
        grid[row][col] = 0;
        for (var dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            
            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1) {
                count += countIslandArea(grid, newRow, newCol);
            }
        }
        return count;
    }
}
