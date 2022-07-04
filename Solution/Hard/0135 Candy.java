class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        
        // assign 1 candy to all children initially
        Arrays.fill(candies, 1);
        
        // left-to-right traversal
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1; 
            }
        }
        
        // right-to-left traversal & count the candies required
        int count = candies[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i + 1] + 1, candies[i]);
            }
            count += candies[i];
        }
        
        return count;
    }
}
