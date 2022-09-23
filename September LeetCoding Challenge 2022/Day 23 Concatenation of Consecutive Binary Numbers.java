class Solution {
    public int concatenatedBinary(int n) {
        final long MOD = 1000_000_007;
        long result = 0;
        for (int i = 1; i <= n; i++) {
            result = (((result << lenOfBin(i)) % MOD) + i) % MOD; 
        }
        return (int) result;
    }
    
    private int lenOfBin(int num) {
        return ((int) (Math.log(num) / Math.log(2))) + 1;
    }
}
