class Solution {
    public boolean isAnagram(String s, String t) {
        int[] cache = new int[26];
        for (char c : s.toCharArray()) {
            cache[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            cache[c - 'a']--;
        }
        for (int i : cache) {
            if (i != 0) return false;
        }
        return true;
    }
}
