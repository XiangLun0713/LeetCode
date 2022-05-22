class Solution {
    public int countSubstrings(String s) {
    int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += countExtendPalindrome(s, i, i);
            result += countExtendPalindrome(s, i, i + 1);
        }
        return result;
    }
    
    private int countExtendPalindrome(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; left--; right++;
        }
        return count;
    }
}
