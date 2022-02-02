class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            if (isAnagrams(s.substring(i, i + p.length()), p)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isAnagrams(String s1, String s2) {
        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for (int res : letters) {
            if (res != 0) {
                return false;
            }
        }
        return true;
    }
}
