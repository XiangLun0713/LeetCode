class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
        int len1 = s1.length(), len2 = s2.length();
        if (len1 + len2 != s3.length()) return false;
        return dfs(c1, c2, c3, 0, 0, 0, new boolean[len1 + 1][len2 + 1]);
    }
    
    private boolean dfs(char[] c1, char[] c2, char[] c3, int idx1, int idx2, int idx3, boolean[][] invalid) {
        if (invalid[idx1][idx2]) return false;
        if (idx3 == c3.length) return true;
        
        boolean valid = idx1 < c1.length && c1[idx1] == c3[idx3] && dfs(c1, c2, c3, idx1 + 1, idx2, idx3 + 1, invalid) ||
                        idx2 < c2.length && c2[idx2] == c3[idx3] && dfs(c1, c2, c3, idx1, idx2 + 1, idx3 + 1, invalid);
        
        if (!valid) invalid[idx1][idx2] = true;
        return valid;
    } 
}
