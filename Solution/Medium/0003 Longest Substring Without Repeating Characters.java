class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int j = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (hashMap.containsKey(curr)) {
                j = Math.max(j, hashMap.get(curr) + 1); // prevent the pointer j from moving backwards
            }
            hashMap.put(curr, i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
