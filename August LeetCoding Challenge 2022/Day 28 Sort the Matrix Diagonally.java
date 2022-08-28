class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int numOfRow = mat.length, numOfCol = mat[0].length;
        
        for (int i = numOfRow - 2; i >= 0; i--) {
            int row = i, col = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            while (row < numOfRow && col < numOfCol) {
                pq.offer(mat[row++][col++]);
            }
            row = i;
            col = 0;
            while (row < numOfRow && col < numOfCol) {
                mat[row++][col++] = pq.poll();
            }
        }
        
        for (int i = 1; i < numOfCol - 1; i++) {
            int row = 0, col = i;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            while (row < numOfRow && col < numOfCol) {
                pq.offer(mat[row++][col++]);
            }
            row = 0;
            col = i;
            while (row < numOfRow && col < numOfCol) {
                mat[row++][col++] = pq.poll();
            }
        }
        return mat;
    }
}
