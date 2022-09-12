class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        
        int score = 0, left = 0, right = tokens.length - 1;
        while(left <= right) {
            if (power < tokens[left]) {
                if (score == 0) return score;
                score--;
                power += tokens[right--];
            }
            score++;
            power -= tokens[left++];
        }
        
        return score;
    }
}
