// Using Dijkstra's algorithm  
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;

        int[][] efforts = new int[row][col];
        for (int[] res : efforts) {
            Arrays.fill(res, Integer.MAX_VALUE);
        }

        // this queue stores an array of length 3, where
        // arr[0] = effort
        // arr[1] = row
        // arr[2] = col
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.offer(new int[]{0, 0, 0});

        int[][] moves = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            if (arr[1] == row - 1 && arr[2] == col - 1) return arr[0];
            for (int[] move : moves) {
                int newRow = arr[1] + move[0];
                int newCol = arr[2] + move[1];
                if (newRow < row && newRow >= 0 && newCol < col && newCol >= 0) {
                    int effort = Math.max(arr[0], Math.abs(heights[newRow][newCol] - heights[arr[1]][arr[2]]));
                    if (effort < efforts[newRow][newCol]) {
                        queue.offer(new int[]{effort, newRow, newCol});
                        efforts[newRow][newCol] = Math.min(efforts[newRow][newCol], effort);
                    }
                }
            }
        }
        return -1;
    }
}
