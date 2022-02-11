class Solution {
    public int singleNumber(int[] nums) {
        int sum = 0;
        for (int res : nums) {
            sum ^= res;
        }
        return sum;
    }
}
