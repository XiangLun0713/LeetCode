class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] dp = new int[n];
        
        for (int i = 0, prevMax = 0; i < n; i++) {
            if (height[i] < prevMax) {
                dp[i] = prevMax - height[i];
            } else {
                prevMax = height[i];  
            }
        }
        
        int count = 0;
        for (int i = n - 1, prevMax = 0; i >= 0; i--) {
            if (height[i] < prevMax) {
                count += Math.min(dp[i], prevMax - height[i]);
            } else {
                prevMax = height[i];  
            }
        }
        
        return count;
    }
}
