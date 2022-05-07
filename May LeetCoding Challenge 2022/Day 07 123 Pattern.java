class Solution {
    public boolean find132pattern(int[] nums) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int maxPossibleK = Integer.MIN_VALUE;
        
        for (int i = nums.length - 1; i >= 0; i--) {
            int curr = nums[i];
            if (curr < maxPossibleK) return true;
            
            while(!stack.isEmpty() && stack.peek() < curr) {
                maxPossibleK = stack.pop();
            }
            stack.push(curr);
        }
        
        return false;
    }
}
