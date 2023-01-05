class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int pointer = points[0][1], count = 0;
        for (int[] curr : points) {
            if (pointer >= curr[0] && pointer <= curr[1]) {
                continue;
            } else {
                pointer = curr[1];
                count++;
            }
        }
        return count + 1;
    }
}
