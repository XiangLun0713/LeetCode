class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        if (s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j));
                j++;
            }
            set.add(s.charAt(i));
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
