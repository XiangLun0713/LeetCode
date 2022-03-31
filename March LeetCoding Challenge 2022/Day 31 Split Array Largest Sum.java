class Solution {
    public static int splitArray(int[] nums, int m) {
        int low = Integer.MIN_VALUE;
        int high = 0;

        for (int res : nums) {
            high += res;
            if (res > low) {
                low = res;
            }
        }

        int result = 0;
        while (high >= low) {
            int mid = low + (high - low) / 2;
            int count = 1, sum = 0;
            for (int res : nums) {
                sum += res;
                if (sum > mid) {
                    count++;
                    sum = res;
                }
            }

            if (count > m) {
                low = mid + 1;
            } else {
                result = mid;
                high = mid - 1;
            }
        }

        return result;
    }
}
