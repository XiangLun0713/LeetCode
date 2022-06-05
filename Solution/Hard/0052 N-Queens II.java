class Solution {
    private int result = 0;
    public int totalNQueens(int n) {
        backtrack(n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return result;
    }
    
    public void backtrack(int n, int currRow, Set<Integer> cols, Set<Integer> posDiag, Set<Integer> negDiag) {
        if (currRow == n) {
            result++;
        } else {
            for (int col = 0; col < n; col++) {
                if (!cols.contains(col) && !posDiag.contains(col + currRow) && !negDiag.contains(col - currRow)) {
                    cols.add(col);
                    posDiag.add(col + currRow);
                    negDiag.add(col - currRow);
                    backtrack(n, currRow + 1, cols, posDiag, negDiag);
                    cols.remove(col);
                    posDiag.remove(col + currRow);
                    negDiag.remove(col - currRow);   
                }
            }
        }
    }
}
