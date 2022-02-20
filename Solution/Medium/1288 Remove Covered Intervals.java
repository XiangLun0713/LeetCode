class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        java.util.Arrays.sort(intervals, Comparator.comparingDouble(a -> a[0]));
        int prevLeft = intervals[0][0], prevRight = intervals[0][1], count = 1;
        for (var res : intervals) {
            if (prevLeft < res[0] && prevRight < res[1]) {
                count++;
                prevLeft = res[0];
                prevRight = res[1];
            } else if (prevLeft == res[0] && prevRight < res[1]) {
                prevRight = res[1];
            } else if (prevRight == res[1] && prevLeft > res[0]) {
                prevLeft = res[0];
            }
        }
        return count;
    }
}
