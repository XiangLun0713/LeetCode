class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                if(i - 1 == j) {
                    result.add(String.valueOf(nums[j]));
                } else {
                    result.add(nums[j] + "->" + nums[i - 1]);
                }
                j = i;
            } 
        }
        if(j == nums.length - 1) {
            result.add(String.valueOf(nums[j]));
        } else {
            result.add(nums[j] + "->" + nums[nums.length - 1]);
        }
        return result;
    }
}
