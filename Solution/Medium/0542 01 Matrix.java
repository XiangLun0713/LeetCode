class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] indices = queue.poll();
            try {
                if (mat[indices[0] - 1][indices[1]] == -1) {
                    mat[indices[0] - 1][indices[1]] = mat[indices[0]][indices[1]] + 1;
                    queue.offer(new int[]{indices[0] - 1, indices[1]});
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {
            }
            try {
                if (mat[indices[0] + 1][indices[1]] == -1) {
                    mat[indices[0] + 1][indices[1]] = mat[indices[0]][indices[1]] + 1;
                    queue.offer(new int[]{indices[0] + 1, indices[1]});
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {
            }
            try {
                if (mat[indices[0]][indices[1] - 1] == -1) {
                    mat[indices[0]][indices[1] - 1] = mat[indices[0]][indices[1]] + 1;
                    queue.offer(new int[]{indices[0], indices[1] - 1});
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {
            }
            try {
                if (mat[indices[0]][indices[1] + 1] == -1) {
                    mat[indices[0]][indices[1] + 1] = mat[indices[0]][indices[1]] + 1;
                    queue.offer(new int[]{indices[0], indices[1] + 1});
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {
            }
        }
        return mat;
    }
}
