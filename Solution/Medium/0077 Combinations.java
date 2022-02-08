class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k <= 0 || n < k) return result;
        for (int i = 1; i <= n; i++) {
            dfs(result, new ArrayList<>(), i, n, k - 1);
        }
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> prePath, int currentInt, int n, int k) {
        List<Integer> path = new ArrayList<>(prePath);
        path.add(currentInt);
        if (k == 0) {
            result.add(path);
        } else {
            for (int i = currentInt + 1; i <= n; i++) {
                dfs(result, path, i, n, k - 1);
            }
        }
    }
}
