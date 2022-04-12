class Solution {
    public void gameOfLife(int[][] board) {
        int row = board.length;
        ;
        int col = board[0].length;
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int count = findLifeNeighbors(board, row, col, i, j);
                if (board[i][j] == 1) {
                    if (count < 2) {
                        result[i][j] = 0;
                    } else if (count < 4) {
                        result[i][j] = 1;
                    } else {
                        result[i][j] = 0;
                    }
                } else {
                    if (count == 3) {
                        result[i][j] = 1;
                    } else {
                        result[i][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < row; i++) {
            System.arraycopy(result[i], 0, board[i], 0, col);
        }
    }

    private int findLifeNeighbors(int[][] board, int row, int col, int i, int j) {
        int count = 0;
        try {
            if (board[i - 1][j - 1] == 1) count++;
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            if (board[i - 1][j] == 1) count++;
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            if (board[i - 1][j + 1] == 1) count++;
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            if (board[i][j - 1] == 1) count++;
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            if (board[i][j + 1] == 1) count++;
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            if (board[i + 1][j - 1] == 1) count++;
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            if (board[i + 1][j] == 1) count++;
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            if (board[i + 1][j + 1] == 1) count++;
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        return count;
    }
}
