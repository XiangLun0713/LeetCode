class Solution {
    public int brokenCalc(int startValue, int target) {
        int count = 0;
        while (target > startValue) {
            if (target % 2 == 0) {
                target /= 2;
                count++;
            } else {
                target = (target + 1) / 2;
                count += 2;
            }
        }
        count += startValue - target;
        return count;
    }
}
