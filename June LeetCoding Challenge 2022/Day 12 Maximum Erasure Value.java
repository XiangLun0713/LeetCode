class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int sum = 0, max = 0, i = 0, j = 0;
        Set<Integer> set = new HashSet<>();
        while (i < nums.length && j < nums.length) {
            int curr = nums[j];
            if (!set.contains(curr)) {
                sum += curr;
                max = Math.max(max, sum);
                set.add(curr);
                j++;
            } else {
                sum = sum - nums[i];
                set.remove(nums[i]);
                i++;
            }
        }
        return max;
    }
}
