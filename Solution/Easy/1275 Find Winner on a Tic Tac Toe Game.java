class Solution {
    public String tictactoe(int[][] moves) {
        char[][] board = new char[3][3];
        int count = 0;
        for (var res : moves) {
            if (count % 2 == 0) {
                board[res[0]][res[1]] = 'X';
            } else {
                board[res[0]][res[1]] = 'O';
            }
            count++;
        }
        
        char midChar = board[1][1];
        if ((midChar != '\u0000') && ((board[0][0] == midChar && board[2][2] == midChar) || (board[0][1] == midChar && board[2][1] == midChar) || (board[0][2] == midChar && board[2][0] == midChar) || (board[1][0] == midChar && board[1][2] == midChar))) {
            return (midChar == 'X') ? "A" : "B";
        } else if ((board[0][0] != '\u0000') && ((board[0][0] == board[0][1] && board[0][0] == board[0][2]) || (board[0][0] == board[1][0] && board[0][0] == board[2][0]))) {
            return (board[0][0] == 'X') ? "A" : "B";
        } else if ((board[2][2] != '\u0000') && ((board[2][2] == board[0][2] && board[2][2] == board[1][2]) || (board[2][2] == board[2][0] && board[2][2] == board[2][1]))) {
            return (board[2][2] == 'X') ? "A" : "B";
        } else if (containsNullElement(board)) {
            return "Pending";
        } else {
            return "Draw";
        }
    }

    private boolean containsNullElement(char[][] arr) {
        for (var res : arr) {
            for (var res1 : res) {
                if (res1 == '\u0000') {
                    return true;
                }
            }
        }
        return false;
    }
}
