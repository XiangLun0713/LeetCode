class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] res : matrix) {
            if (res[res.length - 1] >= target) {
                int high = res.length - 1;
                int low = 0;
                while (high >= low) {
                    int mid = low + (high - low) / 2;
                    if (res[mid] > target) {
                        high = mid - 1;
                    } else if (res[mid] < target) {
                        low = mid + 1;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
