class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int requiredNumber = target - numbers[i];

            // Use binary search to search for the required number
            int high = numbers.length - 1;
            int low = i + 1;
            while (high >= low) {
                int mid = low + (high - low) / 2;
                if (numbers[mid] > requiredNumber) {
                    high = mid - 1;
                } else if (numbers[mid] < requiredNumber) {
                    low = mid + 1;
                } else {
                    return new int[]{i + 1, mid + 1};
                }
            }
        }
        return null;
    }
}
