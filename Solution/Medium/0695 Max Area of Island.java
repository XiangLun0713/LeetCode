class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int row, int column) {
        int count = 1;
        grid[row][column] = 0;
        try {
            if (grid[row - 1][column] == 1) {
                count += dfs(grid, row - 1, column);
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        try {
            if (grid[row + 1][column] == 1) {
                count += dfs(grid, row + 1, column);
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        try {
            if (grid[row][column - 1] == 1) {
                count += dfs(grid, row, column - 1);
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        try {
            if (grid[row][column + 1] == 1) {
                count += dfs(grid, row, column + 1);
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        return count;
    }
}
