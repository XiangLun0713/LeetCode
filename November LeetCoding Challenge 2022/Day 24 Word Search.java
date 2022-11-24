class Solution {
    public boolean exist(char[][] board, String word) {
        int numOfRow = board.length;
        int numOfCol = board[0].length;
        for (int row = 0; row < numOfRow; row++) {
            for (int col = 0; col < numOfCol; col++) {
                if (board[row][col] == word.charAt(0)) {
                    boolean[][] visited = new boolean[numOfRow][numOfCol];
                    visited[row][col] = true;
                    if (backtrack(board, visited, word, row, col, 1)) return true;
                }
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board, boolean[][] visited, String word, int row, int col, int index) {
        if (index == word.length()) return true;
        
        int numOfRow = board.length;
        int numOfCol = board[0].length;
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newCol >= 0 && newCol < numOfCol && newRow >= 0 && newRow < numOfRow && !visited[newRow][newCol]) {
                visited[newRow][newCol] = true;
                if (board[newRow][newCol] == word.charAt(index) && backtrack(board, visited, word, newRow, newCol, index + 1)) return true; 
                visited[newRow][newCol] = false;
            }
        }
        return false;
    }
}
