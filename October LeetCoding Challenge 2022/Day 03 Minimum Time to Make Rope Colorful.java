class Solution {
    public int minCost(String colors, int[] neededTime) {
        int result = 0;
        int fast = 0, slow = 0;
        while (fast < colors.length()) {
            if ((colors.charAt(fast) != colors.charAt(slow))) {
                if (fast - slow > 1) {
                    int sum = 0;
                    int max = Integer.MIN_VALUE;
                    for (int i = slow; i < fast; i++) {
                        max = Math.max(neededTime[i], max);
                        sum += neededTime[i];
                    }
                    result += (sum - max);
                }
                slow = fast;
            }
            fast++;
        }
        if (fast - slow > 1) {
            int sum = 0;
            int max = Integer.MIN_VALUE;
            for (int i = slow; i < fast; i++) {
                max = Math.max(neededTime[i], max);
                sum += neededTime[i];
            }
            result += (sum - max);
        }

        return result;
    }
}
