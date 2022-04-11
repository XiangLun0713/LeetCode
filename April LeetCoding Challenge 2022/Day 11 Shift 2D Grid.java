class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;

        List<List<Integer>> result = new ArrayList<>(row);
        for (int[] ints : grid) {
            result.add(new ArrayList<>(Arrays.stream(ints).boxed().toList()));
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int newRowIndex = (i + ((j + k) / col)) % row;
                int newColIndex = (j + k) % col;
                result.get(newRowIndex).set(newColIndex, grid[i][j]);
            }
        }
        return result;
    }
}
