class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        
        int numOfRow = heights.length;
        int numOfCol = heights[0].length;
        
        boolean[][] fillPacificCache = new boolean[numOfRow][numOfCol];
        boolean[][] fillAtlanticCache = new boolean[numOfRow][numOfCol];
                
        for (int i = 0; i < numOfCol; i++) {
            // fill land starting from top side
            fillFromOcean(heights, fillPacificCache, 0, i, numOfRow, numOfCol);
            
            // fill land starting from bottom side
            fillFromOcean(heights, fillAtlanticCache, numOfRow - 1, i, numOfRow, numOfCol);
        }
        
        for (int i = 0; i < numOfRow; i++) {
            // fill land starting from left side
            fillFromOcean(heights, fillPacificCache, i, 0, numOfRow, numOfCol);
            
            // fill land starting from right side
            fillFromOcean(heights, fillAtlanticCache, i, numOfCol - 1, numOfRow, numOfCol);
        }

        for (int r = 0; r < numOfRow; r++) {
            for (int c = 0; c < numOfCol; c++) {
                if (fillPacificCache[r][c] && fillAtlanticCache[r][c]) result.add(new ArrayList<>(List.of(r, c)));
            }
        }
        
        return result;
    }
    
    private void fillFromOcean(int[][] heights, boolean[][] cache, int row, int col, int numOfRow, int numOfCol) {
        if (cache[row][col]) return;
        
        cache[row][col] = true;
        
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            
            if (newRow >= 0 && newRow < numOfRow && newCol >= 0 && newCol < numOfCol && heights[row][col] <= heights[newRow][newCol]) 
                fillFromOcean(heights, cache, newRow, newCol, numOfRow, numOfCol);
        }
    }
}
