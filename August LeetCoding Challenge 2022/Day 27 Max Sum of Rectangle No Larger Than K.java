class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int numOfRow = matrix.length, numOfCol = matrix[0].length;
        int result = Integer.MIN_VALUE;
        
        for (int left = 0; left < numOfCol; left++) {
            int[] temp = new int[numOfRow];
            
            for (int right = left; right < numOfCol; right++) {
                for (int i = 0; i < numOfRow; i++) {
                    temp[i] += matrix[i][right];
                }
                
                TreeSet<Integer> set = new TreeSet<Integer>();
                set.add(0);
                int currSum = 0;
                
                for (int sum : temp) {
                    currSum += sum;
                    Integer num = set.ceiling(currSum - k);
                    if(num != null) result = Math.max( result, currSum - num );
                    set.add(currSum);
                }
            }
        }
        return result;
    }
}
