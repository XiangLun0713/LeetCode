class Solution {
    int res = 0, empty = 1, startRow, startCol;
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) empty++;
                else if (grid[row][col] == 1) {
                    startRow = row;
                    startCol = col;
                }
            }
        }
        dfs(grid, startRow, startCol);
        return res;
    }

    private void dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] < 0) return;
        if (grid[row][col] == 2) {
            if (empty == 0) res++;
            return;
        } 
        grid[row][col] = -2;
        empty--;
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
        grid[row][col] = 0;
        empty++;
    }
}
