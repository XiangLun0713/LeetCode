class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split("\\s");
        if (pattern.length() != words.length) return false;
        String[] map = new String[26];
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map[c - 'a'] != null) {
                if (!map[c - 'a'].equals(words[i])) return false;
            } else {
                map[c - 'a'] = words[i];
                if(!visited.add(words[i])) return false;
            }
        }
        return true;
    }
}
