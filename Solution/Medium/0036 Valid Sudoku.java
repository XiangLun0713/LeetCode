class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<>();
        // checking each row
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                if (!set.add(c)) {
                    return false;
                }
            }
            set.clear();
        }
        // checking each column
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];
                if (c == '.') continue;
                if (!set.add(c)) {
                    return false;
                }
            }
            set.clear();
        }
        // checking 3x3 box
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        char c = board[i][j];
                        if (c == '.') continue;
                        if (!set.add(c)) {
                            return false;
                        }
                    }
                }
                set.clear();
            }
        }
        return true;
    }
}
