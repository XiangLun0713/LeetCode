class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] arr = new int[nums.length + 2];
        System.arraycopy(nums, 0, arr, 2, nums.length);
        for (int i = 2; i < arr.length - 1; i++) {
            arr[i] = Math.max(arr[i] + arr[i - 2], arr[i - 1]);
        }
        int rob1 = arr[arr.length - 2];
        
        Arrays.fill(arr, 0);
        System.arraycopy(nums, 0, arr, 0, nums.length);
        for (int i = arr.length - 3; i >= 1; i--) {
            arr[i] = Math.max(arr[i] + arr[i + 2], arr[i + 1]);
        }
        int rob2 = arr[1];

        return Math.max(rob1, rob2);
    }
}
