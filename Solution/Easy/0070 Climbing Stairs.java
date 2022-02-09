class Solution {
    public int climbStairs(int n) {
        Integer[] memoize = new Integer[n + 1];
        memoize[n] = 1;
        memoize[n - 1] = 1;
        findNumberOfWays(n, memoize);
        return memoize[0];
    }

    private void findNumberOfWays(int n, Integer[] memoize) {
        if (n - 2 >= 0) {
            memoize[n - 2] = memoize[n] + memoize[n - 1];
            findNumberOfWays(n - 1, memoize);
        }
    }
}
