class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        final int WINDOW_SIZE = p.length();
        int[] targetFreq = getFreq(p);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length() - WINDOW_SIZE + 1; i++) {
            String temp = s.substring(i, i + WINDOW_SIZE);
            if (Arrays.equals(getFreq(temp), targetFreq)) result.add(i);
        }
        return result;
    }

    private int[] getFreq(String s) {
        int[] freq =  new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }
}
