class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        Arrays.sort(nums);
        dfs(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> path, int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            List<Integer> tempPath = new ArrayList<>(path);
            tempPath.add(nums[i]);
            result.add(tempPath);
            dfs(result, tempPath, nums, i + 1);
        }
    }
}
