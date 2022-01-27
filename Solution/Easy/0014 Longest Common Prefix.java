class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        int minLength = strs[0].length();
        for (var res : strs) {
            if (res.length() < minLength) {
                minLength = res.length();
            }
        }
        stop:
        for (int i = 0; i < minLength; i++) {
            char currentChar = strs[0].charAt(i);
            boolean sameCharForAllElement = true;
            for (var res : strs) {
                if (res.charAt(i) != currentChar) {
                    sameCharForAllElement = false;
                    break stop;
                }
            }
            result += currentChar;
        }
        return result;
    }
}
