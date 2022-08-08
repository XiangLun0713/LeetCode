    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        
        int[] dp = new int[n];
        dp[n - 1] = 1;
        
        int maxLIS = 0;
        for (int i = n - 2; i >= 0; i--) {
            int max = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) 
                    max = Math.max(max, dp[j] + 1);
            }
            dp[i] = max;
            maxLIS = Math.max(max, maxLIS);
        }
        
        return maxLIS;
    }
