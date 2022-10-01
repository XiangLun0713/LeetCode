class Solution {
    public int numDecodings(String s) {
        int[] memoize = new int[s.length() + 1];
        return helper(s, 0, memoize);
    }
    
    private int helper(String s, int index, int[] memoize) {
        int n = s.length();
        if (index == n) return 1;
        if (s.charAt(index) == '0') return 0;
        if (memoize[index] != 0) return memoize[index];
        
        int count = helper(s, index + 1, memoize);
        if (index + 1 < n && Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            count += helper(s, index + 2, memoize);
        }
        return memoize[index] = count;
    }
}
