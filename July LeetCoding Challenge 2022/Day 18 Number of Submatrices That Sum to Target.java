class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int numOfRow = matrix.length;
        int numOfCol = matrix[0].length;
        
        for (int i = 0; i < numOfRow; i++) {
            for (int j = 1; j < numOfCol; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        
        int count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < numOfCol; i++) {
            for (int j = i; j < numOfCol; j++) {
                hashMap.clear();
                hashMap.put(0, 1);
                
                int pre = 0;
                for (int k = 0; k < numOfRow; k++) {
                    pre += (matrix[k][j] - (i > 0 ? matrix[k][i - 1] : 0));
                    count += hashMap.getOrDefault(pre - target, 0);
                    hashMap.put(pre, hashMap.getOrDefault(pre, 0) + 1);
                }
            }    
        }
        return count;
    }
}
