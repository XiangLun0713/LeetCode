class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = -1, end = -1, n = nums.length;
        int high = n - 1, low = 0, mid = 0;
        boolean found = false;
        while (high >= low) {
            mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                found = true;
                break;
            }
        }

        if (found) {
            int index = mid;
            while (index - 1 >= 0 && nums[index - 1] == target) {
                index--;
            }
            while (mid + 1 < n && nums[mid + 1] == target) {
                mid++;
            }
            start = index;
            end = mid;
        }

        return new int[] {start, end};
    }
}
