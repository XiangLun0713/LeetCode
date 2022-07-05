class Solution {
    public int longestConsecutive(int[] nums) {
        // populate the set with all the elements in nums
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        // find longest streak
        int longestStreak = 0;
        for (int num : nums) {
            // if the set does not contain num - 1,
            // this means that the current num is a possible starting point of a streak
            if (!set.contains(num - 1)) {
                int streak = 1;
                
                // keep incrementing the num and keep track of the streak count 
                while (set.contains(++num)) {
                    streak++;
                }
                
                // update the longest streak if needed
                longestStreak = Math.max(longestStreak, streak);
            }
        }
        return longestStreak;
    }
}
