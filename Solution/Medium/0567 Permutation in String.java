class Solution {
    public boolean checkInclusion(String s1, String s2) {
        final int WINDOW_SIZE = s1.length();
        if (WINDOW_SIZE == 0 || s2.length() < WINDOW_SIZE) return false;
        int[] freqOfS1 = freq(s1);
        int[] freqOfS2 = freq(s2.substring(0, WINDOW_SIZE));
        if (equalArray(freqOfS1, freqOfS2)) return true;
        for (int i = 0; i < s2.length() - WINDOW_SIZE; i++) {
            freqOfS2[s2.charAt(i) - 'a']--;
            freqOfS2[s2.charAt(i + WINDOW_SIZE) - 'a']++;
            if (equalArray(freqOfS1, freqOfS2))
                return true;
        }
        return false;
    }

    private int[] freq(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        return freq;
    }

    private boolean equalArray(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }
}
