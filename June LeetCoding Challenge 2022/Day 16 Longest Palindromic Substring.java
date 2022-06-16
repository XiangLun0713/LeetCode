class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                String temp = s.substring(left, right + 1);
                if (temp.length() > len) {
                    len = temp.length();
                    result = temp;
                }
                left--;
                right++;
            }

            left = i;
            right = i + 1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                String temp = s.substring(left, right + 1);
                if (temp.length() > len) {
                    len = temp.length();
                    result = temp;
                }
                left--;
                right++;
            }
        }
        return result;
    }
}
