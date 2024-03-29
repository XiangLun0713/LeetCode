class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        dfs(result, "", s, 0);
        return result;
    }
    
    private void dfs(List<String> result, String path, String s, int k) {
        if (s.isEmpty() || k == 4) {
            if (s.isEmpty() && k == 4)
                result.add(path.substring(1));
            return;
        }
        for (int i = 1; i <= (s.charAt(0) == '0' ? 1 : 3) && i <= s.length(); i++) { 
            String part = s.substring(0, i);
            if (Integer.valueOf(part) <= 255)
                dfs(result, path + "." + part, s.substring(i), k + 1);
        }
    }
}
