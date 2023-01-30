class Solution {
    public int tribonacci(int n) {
        int[] cache = new int[3];
        cache[1] = 1;
        cache[2] = 1;

        if (n <= 2) return cache[n];

        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = cache[0] + cache[1] + cache[2];
            cache[i % 3] = sum;
        }

        return sum;
    }
}
