class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] memoize = new int[cost.length + 1];
        System.arraycopy(cost, 0, memoize, 0, cost.length);

        for (int i = memoize.length - 4; i >= 0; i--) {
            memoize[i] += Math.min(memoize[i + 1], memoize[i + 2]);
        }

        return Math.min(memoize[0], memoize[1]);
    }
}
