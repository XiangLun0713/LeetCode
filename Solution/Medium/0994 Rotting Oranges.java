class Solution {
    public int orangesRotting(int[][] grid) {
        int numOfRow = grid.length;
        int numOfCol = grid[0].length;
        boolean noOrange = true;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < numOfRow; i++) {
            for (int j = 0; j < numOfCol; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    noOrange = false;
                }
                if (noOrange && grid[i][j] == 1) {
                    noOrange = false;
                }
            }
        }
        if(noOrange) return 0;
        int count = 0;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int initQueueSize = queue.size();
            for (int i = 0; i < initQueueSize; i++) {
                int[] indices = queue.poll();
                for (var res : dir) {
                    assert indices != null;
                    int row = indices[0] + res[0];
                    int col = indices[1] + res[1];
                    if (row < 0 || row >= numOfRow || col < 0 || col >= numOfCol || grid[row][col] != 1) continue;
                    queue.offer(new int[]{row, col});
                    grid[row][col] = 2;
                }
            }
            count++;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return count - 1;
    }
}
