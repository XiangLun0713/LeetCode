class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int numOfQueries = queries.length;
        int sumOfEven = 0;
        int[] result = new int[numOfQueries];

        for (int num : nums) {
            if (isEven(num)) sumOfEven += num;
        }
        
        for (int i = 0; i < numOfQueries; i++) {
            int[] query = queries[i];
            int initialNum = nums[query[1]];
            int modifiedNum = initialNum + query[0];
            nums[query[1]] = modifiedNum;
            
            if (isEven(initialNum) && isEven(modifiedNum)) {
                sumOfEven = sumOfEven - initialNum + modifiedNum;
            } else if (isEven(initialNum) && !isEven(modifiedNum)) {
                sumOfEven -= initialNum;
            } else if (!isEven(initialNum) && isEven(modifiedNum)) {
                sumOfEven += modifiedNum; 
            }
            
            result[i] = sumOfEven;
        }
        
        return result;
    }
    private boolean isEven(int num) {
        return num % 2 == 0;
    }
}
