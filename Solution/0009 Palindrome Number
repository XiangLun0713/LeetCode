class Solution {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        return s.equals(reversedString(s));
    }

    public String reversedString(String s) {
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.charAt(i);
        }
        return result;
    }
}
