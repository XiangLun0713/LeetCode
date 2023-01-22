class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(s, new ArrayList<>(), result);
        return result;
    }

    private void dfs(String s, List<String> path, List<List<String>> result) {
        if (s == null || s.length() == 0) {
            result.add(path);
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String temp = s.substring(0, i);
            if (!isPalindrome(temp)) continue;
            List<String> newPath = new ArrayList<>(path);
            newPath.add(temp);
            dfs(s.substring(i, s.length()), newPath, result);
        }
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }
}
