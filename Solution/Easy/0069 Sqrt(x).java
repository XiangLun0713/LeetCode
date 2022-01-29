class Solution {
    public int mySqrt(int x) {
        int currentInt = 0;
        while (squareOf(currentInt) <= x) {
            currentInt++;
        }
        return currentInt - 1;
    }

    private long squareOf(long num) {
        return num * num;
    }
}
