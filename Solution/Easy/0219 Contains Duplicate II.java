class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) return false;
        Set<Integer> set = new HashSet<>();
        int left = 0, right = k;
        for (int i = left; i < right + 1; i++) {
            if (i < nums.length && !set.add(nums[i])) return true;
        }
        while(right < nums.length - 1) {
            set.remove(nums[left++]);
            if (!set.add(nums[++right])) return true;
        }
        return false;
    }
}
