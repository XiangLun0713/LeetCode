class Solution {
    private int result = 0;
    
    public int maxLength(List<String> arr) {
        dfs(arr, "", 0);
        return result;
    }
    
    private void dfs(List<String> arr, String path, int index) {
        if (!isUnique(path)) return;
        result = Math.max(result, path.length()); 
        if (index == arr.size()) return;
        for (int i = index; i < arr.size(); i++) {
            dfs(arr, path + arr.get(i), i + 1);
        }
    }
    
    private boolean isUnique(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            if (++freq[c - 'a'] > 1) return false;
        }
        return true;
    }
}
