class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            String res = "";
            for (int j = 0; j < needle.length(); j++) {
                res += haystack.charAt(i + j);
            }
            if (res.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
