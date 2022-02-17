class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int res : candidates) {
            if (res <= target) {
                dfs(res, target, candidates, new ArrayList<>(), result);
            }
        }
        return result;
    }

    private void dfs(int currentInt, int target, int[] candidates, ArrayList<Integer> path, List<List<Integer>> result) {
        target -= currentInt;
        ArrayList<Integer> currentPath = new ArrayList<>(path);
        currentPath.add(currentInt);
        if (target == 0) {
            result.add(currentPath);
            return;
        }
        for (int res :
                candidates) {
            if (res <= target && res >= currentInt) {
                dfs(res, target, candidates, currentPath, result);
            }
        }
    }
}
