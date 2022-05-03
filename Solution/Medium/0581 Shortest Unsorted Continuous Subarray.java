class Solution {
    public int findUnsortedSubarray(int[] nums) {
        // a flag to determine that we had entered the unsorted subarray
        boolean flag = false;
        // minimum number in the unsorted subarray
        int min = Integer.MAX_VALUE;
        // maximum number in the unsorted subarray
        int max = Integer.MIN_VALUE;

        // find minimum number in the unsorted subarray
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                flag = true;
            }
            if (flag) {
                min = Math.min(min, nums[i]);
            }
        }

        flag = false;
        // find maximum number in the unsorted subarray
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                flag = true;
            }
            if (flag) {
                max = Math.max(max, nums[i]);
            }
        }

        int start, end;
        // find out the correct location of the min number if the array is sorted
        for (start = 0; start < nums.length; start++) {
            if (nums[start] > min) {
                break;
            }
        }

        // find out the correct location of the max number if the array is sorted
        for (end = nums.length - 1; end >= 0; end--) {
            if (nums[end] < max) {
                break;
            }
        }

        // if flagged before, this array has unsorted subarray, thus need to return the length
        // else, this array is already sorted, thus need to return 0
        return flag ? end - start + 1 : 0;
    }
}
