class Solution {
    private List<List<String>> result = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        backTracking(n, 0, board, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return result;
    }
    
    private void backTracking(int n, int row, int[][] board, Set<Integer> cols, Set<Integer> posDiag, Set<Integer> negDiag) {
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (int[] rank : board) {
                String s = "";
                for (int square : rank) {
                    if (square == 1) {
                        s += "Q";
                    } else {
                        s += ".";
                    }
                }
                temp.add(s);
            }
            result.add(temp);
        }
        
        for (int i = 0; i < n; i++) {
            if (!cols.contains(i) && !posDiag.contains(row + i) && !negDiag.contains(row - i)) {
                board[row][i] = 1;
                cols.add(i);
                posDiag.add(row + i);
                negDiag.add(row - i);
                backTracking(n, row + 1, board, cols, posDiag, negDiag);
                board[row][i] = 0;
                cols.remove(i);
                posDiag.remove(row + i);
                negDiag.remove(row - i);
            }
        }
    }
}
