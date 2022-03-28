class Solution {
    public boolean search(int[] nums, int target) {
        Arrays.sort(nums);
        int high = nums.length - 1;
        int low = 0;
        while (high >= low) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
