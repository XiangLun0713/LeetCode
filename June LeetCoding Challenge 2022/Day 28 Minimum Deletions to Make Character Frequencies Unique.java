class Solution {
    public int minDeletions(String s) {
        int numOfDeletion = 0, maxFreqAllowed = s.length();
        // count the frequency
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // sort the array
        Arrays.sort(freq);

        for (int i = freq.length - 1; i >= 0; i--) {
            int curr = freq[i];
            if (curr == 0) break;    // terminate the loop right away when 0 is found
            
            if (curr > maxFreqAllowed) {
                numOfDeletion += curr - maxFreqAllowed;
                if (maxFreqAllowed > 0) maxFreqAllowed--;
            } else {
                maxFreqAllowed = curr - 1;
            }
        }
        return numOfDeletion;
    }
}
