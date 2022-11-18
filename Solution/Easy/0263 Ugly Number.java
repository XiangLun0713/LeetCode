class Solution {
    public boolean isUgly(int n) {
        if (n == 0) return false;
        for (int i = 2; i < 6; i++) {
            if (i == 4) continue;
            while (n % i == 0) {
                n /= i;
            }
        }
        return n == 1;
    }
}
