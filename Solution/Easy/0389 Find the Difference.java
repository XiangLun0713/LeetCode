class Solution {
    public char findTheDifference(String s, String t) {
        if(s.length() == 0) return t.charAt(0);
        int[] cache = new int[26];
        for(int i = 0; i < t.length(); i++){
            cache[t.charAt(i) - 'a']++;
            if (i == t.length() - 1) continue;
            cache[s.charAt(i) - 'a']--;
        }
        for(int i = 0; i < cache.length; i++){
            if(cache[i] != 0){
                return (char)('a' + i);
            }
        }
        return '\u0000';
    }
}
