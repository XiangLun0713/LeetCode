class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        char[][] arr = new char[numRows][calculateNumCols(s.length(), numRows)];
        int currRow = 0, currCol = 0, direction = 1;    // direction 1 means down, -1 means up
        for (char c : s.toCharArray()) {
            arr[currRow][currCol] = c;
            if (direction == 1) {
                if (currRow == numRows - 1) {
                    // if reached bottom, turn direction to up
                    direction = -1;
                    currCol++;
                    currRow--;
                } else {
                    currRow++;
                }
            } else {
                if (currRow == 0) {
                    // if reached top, turn direction to down
                    direction = 1;
                    currRow++;
                } else {
                    currCol++;
                    currRow--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char[] row : arr) {
            for (char c : row) {
                if (c != '\u0000') {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    private int calculateNumCols(int len, int numRows) {
        int numCols = 1, flag = 0, target = numRows;
        for (int i = 1; i <= len; i++) {
            if (flag > 0) {
                numCols++;
                flag--;
                if (flag == 0) target = i + numRows - 1;
            }
            if (i == target) {
                flag = numRows - 1;
            }
        }
        return numCols;
    }
}
