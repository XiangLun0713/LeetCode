class Solution {
    public boolean increasingTriplet(int[] nums) {
        int big = Integer.MAX_VALUE, small = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > big) return true;
            small = Math.min(small, num);
            if (num > small) big = num;
        }
        return false;
    }
}
