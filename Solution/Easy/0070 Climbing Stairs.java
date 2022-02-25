class Solution {
    public  int climbStairs(int n) {
        if (n <= 2) return n;
        int[] cache = new int[2];
        cache[0] = 1;
        cache[1] = 2;
        int i = 0;
        for (; i < n - 2; i++) {
            cache[i % 2] = cache[0] + cache[1];
        }
        return cache[(i - 1) % 2];
    }
}
