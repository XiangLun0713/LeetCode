class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char curr = board[i][j];
                if (curr == '.') continue;
                if (!set.add(curr + " in row " + i) ||
                    !set.add(curr + " in col " + j) ||
                    !set.add(curr + " in block " + i / 3 + " " + j / 3)) 
                    return false;
            }
        }
        return true;
    }
}
