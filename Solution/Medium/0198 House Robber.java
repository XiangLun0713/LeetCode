class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        int[] arr = new int[nums.length + 2];
        System.arraycopy(nums, 0, arr, 2, nums.length);
        
        for (int i = 2; i < arr.length; i++) {
            arr[i] = Math.max(arr[i] + arr[i - 2], arr[i - 1]);
        }
        
        return arr[arr.length - 1];
    }
}
