class Solution {
    public boolean isPowerOfThree(int n) {
        final int maxPowThreeInt = 1162261467;
        return n > 0 && maxPowThreeInt % n == 0;
    }
}
