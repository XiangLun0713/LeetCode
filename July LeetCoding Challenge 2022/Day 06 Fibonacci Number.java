class Solution {
    public int fib(int n) {
        int[] cache = new int[2];
        cache[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            cache[i % 2] = cache[0] + cache[1];
        }
   
        return cache[n % 2];
    }
}
