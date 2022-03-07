class Solution {
    public int longestPalindrome(String s) {
        if (s.length() == 1) return 1;
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (hashMap.containsKey(curr)) {
                hashMap.put(curr, hashMap.get(curr) + 1);
            } else {
                hashMap.put(curr, 1);
            }
        }

        int count = 0;
        boolean hasOddFreq = false;
        for (int i : hashMap.values()) {
            if (i % 2 == 0) {
                count += i;
            } else {
                count += i - 1;
                hasOddFreq = true;
            }
        }

        return hasOddFreq ? count + 1 : count;
    }
}
