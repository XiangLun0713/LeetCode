// Using Breadth-First-Search(BFS) method
// ***Altering original grid array
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0) return -1;
        int n = grid.length;

        Queue<int[]> queue = new LinkedList<>();
        int[][] dirMap = {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};

        int count = 1;
        queue.offer(new int[] {0, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (grid[curr[0]][curr[1]] != 0) continue;
                grid[curr[0]][curr[1]] = -1; 
                if (curr[0] == n - 1 && curr[1] == n - 1) return count;
                for (int[] dir : dirMap) {
                    int newRow = dir[0] + curr[0];
                    int newCol = dir[1] + curr[1];
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0) {
                        queue.offer(new int[] {newRow, newCol});
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
