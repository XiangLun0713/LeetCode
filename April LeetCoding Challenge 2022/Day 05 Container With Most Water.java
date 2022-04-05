class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            max = Math.max(max, findArea(left, right, height));
            if (height[left] < height[right]) {
                left++;
            } else if (height[left] > height[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return max;
    }
    
    private int findArea(int left, int right, int[] height) {
        return Math.min(height[left], height[right]) * (right - left);
    }
}
