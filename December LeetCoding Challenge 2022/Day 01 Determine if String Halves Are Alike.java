class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int[] left = new int[26];
        int[] right = new int[26];
        for (int i = 0; i < n/2; i++) {
            left[Character.toLowerCase(s.charAt(i)) - 'a']++;
        }
        for (int i = n/2; i < n; i++) {
            right[Character.toLowerCase(s.charAt(i)) - 'a']++;
        }
        return left[0] + left[4] + left[8] + left[14] + left[20] == 
            right[0] + right[4] + right[8] + right[14] + right[20];
    }
}
