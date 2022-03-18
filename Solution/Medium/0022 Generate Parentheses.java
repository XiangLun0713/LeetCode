class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        int open = 0, close = 0;
        dfs(result, n, open, close, "");
        return result;
    }

    private void dfs(List<String> result, int n, int open, int close, String s) {
        if (close == n) {
            result.add(s);
            return;
        }

        if (open < n) {
            dfs(result, n, open + 1, close, s.concat("("));
        }
        if (close < open) {
            dfs(result, n, open, close + 1, s.concat(")"));
        }
    }
}
