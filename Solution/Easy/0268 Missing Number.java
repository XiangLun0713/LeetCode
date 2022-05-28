class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int totalSum = (int)((n / 2.0) * (n + 1));
        for (int i = 1; i < n; i++) {
            totalSum -= i;
        }
        return totalSum;
    }
}
