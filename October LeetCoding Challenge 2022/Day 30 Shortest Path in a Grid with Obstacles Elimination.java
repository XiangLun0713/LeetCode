class Solution {
    public int shortestPath(int[][] grid, int k) {
        int numOfRow = grid.length, numOfCol = grid[0].length;
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, k});
        boolean[][][] visited = new boolean[numOfRow + 1][numOfCol + 1][k + 1];
        visited[0][0][k] = true;
        
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (curr[0] == numOfRow - 1 && curr[1] == numOfCol - 1) return count;
                for (int[] direction : directions) {
                    int newRow = curr[0] + direction[0];
                    int newCol = curr[1] + direction[1];
                    if (newRow >= 0 && newRow < numOfRow && newCol >= 0 && newCol < numOfCol) {
                        if (grid[newRow][newCol] == 0 && !visited[newRow][newCol][curr[2]]) {
                            queue.offer(new int[] {newRow, newCol, curr[2]});
                            visited[newRow][newCol][curr[2]] = true;
                        }
                        if (grid[newRow][newCol] == 1 && curr[2] > 0 && !visited[newRow][newCol][curr[2] - 1]) {
                            queue.offer(new int[] {newRow, newCol, curr[2] - 1});
                            visited[newRow][newCol][curr[2] - 1] = true;
                        }
                    }
                }
            }
            count++;
        }
        
        return -1;
    }
}
