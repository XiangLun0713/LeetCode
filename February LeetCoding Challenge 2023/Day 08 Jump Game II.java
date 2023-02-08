class Solution {
    public int jump(int[] nums) {
        int startPos = 0, endPos = 0, step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            endPos = Math.max(endPos, i + nums[i]);
            if (i == startPos) {
                step++;
                startPos = endPos;
            }
        }
        return step;
    }
}
