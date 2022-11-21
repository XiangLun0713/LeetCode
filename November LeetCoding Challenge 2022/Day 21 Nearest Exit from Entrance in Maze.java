class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] directions = {{1,0},{0,1},{0,-1},{-1,0}};
        int numOfRow = maze.length, numOfCol = maze[0].length, count = 0;
        boolean[][] visited = new boolean[numOfRow][numOfCol];
        Queue<int[]> queue = new LinkedList<>();
        visited[entrance[0]][entrance[1]] = true;
        for (int[] direction : directions) {
            int newRow = entrance[0] + direction[0];
            int newCol = entrance[1] + direction[1];
            if (newRow >= 0 && newRow < numOfRow && newCol >= 0 && newCol < numOfCol) {
                if (maze[newRow][newCol] == '.')
                    queue.offer(new int[] {newRow, newCol});
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (visited[curr[0]][curr[1]]) continue;
                else visited[curr[0]][curr[1]] = true;
                for (int[] direction : directions) {
                    int newRow = curr[0] + direction[0];
                    int newCol = curr[1] + direction[1];
                    if (newRow >= 0 && newRow < numOfRow && newCol >= 0 && newCol < numOfCol) {
                        if (maze[newRow][newCol] == '.')
                            queue.offer(new int[] {newRow, newCol});
                    } else {
                        return count;
                    }
                }
            }
        }
        return -1;
    }
}
