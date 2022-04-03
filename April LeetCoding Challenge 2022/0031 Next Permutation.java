class Solution {
    public void nextPermutation(int[] nums) {
        int maxIndex = 0;
        int maxPrevVal = 0;
        int maxPrevIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                maxIndex = i;
                maxPrevVal = nums[i - 1];
                maxPrevIndex = i - 1;
            }
        }
        if (maxIndex == 0) {
            Arrays.sort(nums);
            return;
        }
        int res = 1;
        int target = maxIndex;
        while (maxIndex + res < nums.length && nums[maxIndex + res] > maxPrevVal) {
            target = maxIndex + res;
            res++;
        }
        int temp = nums[target];
        nums[target] = nums[maxPrevIndex];
        nums[maxPrevIndex] = temp;

        for (int i = maxPrevIndex + 1; i < nums.length - 1; i++) {
            int min = nums[i];
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
    }
}
