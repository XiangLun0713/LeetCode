class Solution {
    public int search(int[] nums, int target) {
        int high = nums.length - 1;
        int low = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            }else if (nums[mid] < target) {
                low = mid + 1;
            }else {
                return mid; 
            }
        }
        return -1;
    }
}
