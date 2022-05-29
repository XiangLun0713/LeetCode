class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] bits = new int[n];
        for (int i = 0; i < n; i++) {
            int num = 0;
            for (char c : words[i].toCharArray()) {
                 num |= (1 << ('z' - c));
            }
            bits[i] = num;
        }
        
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((bits[i] & bits[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
