class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        int row = mat.length;
        int column = mat[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] indices = queue.poll();
            for (int[] res : dir) {
                int currentRow = indices[0] + res[0];
                int currentColumn = indices[1] + res[1];
                if (currentColumn < 0 || currentColumn >= column || currentRow < 0 || currentRow >= row || mat[currentRow][currentColumn] != -1)
                    continue;
                mat[currentRow][currentColumn] = mat[indices[0]][indices[1]] + 1;
                queue.offer(new int[]{currentRow, currentColumn});
            }
        }
        return mat;
    }
}
