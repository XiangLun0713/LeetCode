class Solution {
    public int jump(int[] nums) {
        int steps = 0, startPos = 0, endPos = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            endPos = Math.max(endPos, i + nums[i]);
            if (i == startPos) {
                steps++;
                startPos = endPos;
            }
        }
        return steps;
    }
}
