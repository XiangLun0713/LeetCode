// Using dfs/recursion and backtracking
class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        dfs(n, k, 0, 0, new ArrayList<>());
        return result;
    }

    private void dfs(int n, int k, int sum, int currValue, List<Integer> prePath) {
        if (sum > n) return;
        if (k == 0) {
            if (sum == n) result.add(prePath);
        } else {
            for (int i = currValue + 1; i <= 9; i++) {
                List<Integer> path = new ArrayList<>(prePath);
                path.add(i);
                dfs(n, k - 1, sum + i, i, path);
            }
        }
    }
}
