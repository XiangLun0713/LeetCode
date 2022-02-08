class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0 || nums == null) return null;
        List<List<Integer>> result = new ArrayList<>();
        for (int res : nums) {
            findPermute(nums, result, new ArrayList<>(), res);
        }
        return result;
    }

    private void findPermute(int[] nums, List<List<Integer>> result, List<Integer> prePath, int currentInt) {
        List<Integer> path = new ArrayList<>(prePath);
        path.add(currentInt);
        if (path.size() == nums.length) {
            result.add(path);
        } else {
            for (int res : nums) {
                if (!path.contains(res)) {
                    findPermute(nums, result, path, res);
                }
            }
        }
    }
}
