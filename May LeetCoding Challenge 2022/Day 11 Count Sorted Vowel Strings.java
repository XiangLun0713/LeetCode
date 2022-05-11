class Solution {
    public int countVowelStrings(int n) {
        int[] cache = new int[5];
        Arrays.fill(cache, 1);
        
        for (int i = 1; i < n; i++) {
            for (int j = 3; j >= 0; j--) {
                cache[j] = cache[j] + cache[j + 1];
            }
        }
        
        return IntStream.of(cache).sum();
    }
}
