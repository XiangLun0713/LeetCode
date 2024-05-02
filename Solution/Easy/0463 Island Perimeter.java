class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    perimeter += 4;
                    for (int[] direction : directions) {
                        int newRow = row + direction[0];
                        int newCol = col + direction[1];
                        if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                                && grid[newRow][newCol] == 1) {
                            perimeter--;
                        }
                    }
                }
            }
        }
        return perimeter;
    }
}
