// DFS solution using recursion & backtracking
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() <= 0) return result;
        String[] arr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "xywz"};
        dfs(result, arr, digits, "",0);
        return result;
    }

    private void dfs (List<String> result, String[] arr, String digits, String path, int index) {
        if (index >= digits.length()) {
            result.add(path);

        } else {
            for (char c : arr[digits.charAt(index) - '0'].toCharArray()) {
                dfs(result, arr, digits, path + c, index + 1);
            }
        }
    }
}
