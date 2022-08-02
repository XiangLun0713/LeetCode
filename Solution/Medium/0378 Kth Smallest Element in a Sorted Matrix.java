class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int[] arr = new int[matrix.length * matrix[0].length];
        int i = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                arr[i++] = num;
            }
        }
        
        Arrays.sort(arr);
        return arr[k - 1];
    }
}
