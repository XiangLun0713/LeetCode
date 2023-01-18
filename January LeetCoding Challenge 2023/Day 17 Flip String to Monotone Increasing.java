class Solution {
    public int minFlipsMonoIncr(String s) {
        int result = 0, numberOfFlip = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') result = Math.min(numberOfFlip, result + 1);
            else numberOfFlip++;
        }
        return result;
    }
}
