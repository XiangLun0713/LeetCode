class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) {
            return result;
        }
        final int WINDOW_SIZE = p.length();
        int[] freqOfS = freq(s.substring(0, WINDOW_SIZE));
        int[] freqOfP = freq(p);

        for (int i = 0; i < s.length(); i++) {
            int j = i + WINDOW_SIZE;
            if (equalArray(freqOfP, freqOfS)) {
                result.add(i);
            }
            try {
                freqOfS[s.charAt(i) - 'a']--;
                freqOfS[s.charAt(j) - 'a']++;

            } catch (StringIndexOutOfBoundsException e) {
                break;
            }
        }
        return result;
    }

    private boolean equalArray(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] freq(String a) {
        int[] freq = new int[26];
        for (int i = 0; i < a.length(); i++) {
            freq[a.charAt(i) - 'a']++;
        }
        return freq;
    }
}
