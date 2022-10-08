class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int first = 0, closest = Integer.MAX_VALUE;
        Arrays.sort(nums);
        while (first < nums.length - 2) {
            int second = first + 1, third = nums.length - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum < target) {
                    second++;
                } else if (sum > target) {
                    third--;
                } else {
                    return target;
                }
                if (Math.abs(target - sum) < Math.abs(target - closest)) closest = sum;
            }
            first++;
        }
        return closest;
    }
}
