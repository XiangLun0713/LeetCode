class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        // sort the arrays in ascending order
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        // find max height
        long maxHeight = horizontalCuts[0];
        for (int i = 1; i < horizontalCuts.length; i++) {
            maxHeight = Math.max(maxHeight, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        maxHeight = Math.max(maxHeight, h - horizontalCuts[horizontalCuts.length - 1]);
        
        // find max width
        long maxWidth = verticalCuts[0];
        for (int i = 1; i < verticalCuts.length; i++) {
            maxWidth = Math.max(maxWidth, verticalCuts[i] - verticalCuts[i - 1]);
        }
        maxWidth = Math.max(maxWidth, w - verticalCuts[verticalCuts.length - 1]);

        return (int) ((maxWidth * maxHeight) % (1000_000_007));
    }
}
