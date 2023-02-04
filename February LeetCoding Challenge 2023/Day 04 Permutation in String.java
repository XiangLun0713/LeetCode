class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int WINDOW_SIZE = s1.length();
        int[] s1Freq = getFreq(s1);

        for (int i = 0; i < s2.length() - WINDOW_SIZE + 1; i++) {
            String temp = s2.substring(i, i + WINDOW_SIZE);
            if (Arrays.equals(getFreq(temp), s1Freq)) return true;
        }

        return false;
    }
    private int[] getFreq(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }
}
