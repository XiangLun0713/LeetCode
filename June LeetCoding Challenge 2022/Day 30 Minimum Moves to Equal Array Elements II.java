class Solution {
    public int minMoves2(int[] nums) {
        // sort the array
        Arrays.sort(nums);

        // get the target optimal point (namely the middle element after sorting)
        int mid = 0, n = nums.length;
        if (n % 2 == 0) {
            // if is length even
            mid = (nums[n / 2 - 1] - nums[n / 2]) / 2 + nums[n / 2];     // prevent overflow
        } else {
            // if is length odd
            mid = nums[n / 2];
        }

        // calculate the steps required
        int count = 0;
        for (int num : nums) {
            count += Math.abs(mid - num);
        }

        return count;
    }
}
