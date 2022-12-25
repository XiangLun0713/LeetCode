class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] preSum = new int[nums.length];
        int idx = 0, sum = 0;
        for (int num : nums) {
            preSum[idx++] = sum += num;
        }
        idx = 0;
        int[] result = new int[queries.length];
        for (int query : queries) {
            int temp = Arrays.binarySearch(preSum, query);
            result[idx++] = (temp < 0) ? -(temp + 1) : temp + 1;
        }
        return result;
    }
}
