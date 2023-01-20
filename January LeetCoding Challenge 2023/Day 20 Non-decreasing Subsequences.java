class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        dfs(0, new ArrayList<>(), set, nums);
        return new ArrayList<>(set);
    }
    
    private void dfs(int idx, List<Integer> path, Set<List<Integer>> set, int[] nums) {
        if (path.size() >= 2) set.add(new ArrayList<>(path));

        for (int i = idx; i < nums.length; i++) {
            if (path.size() == 0 || nums[i] >= path.get(path.size() - 1)) {
                path.add(nums[i]);
                dfs(i + 1, path, set, nums);
                path.remove(path.size() - 1);
            }
        }
    }
}
