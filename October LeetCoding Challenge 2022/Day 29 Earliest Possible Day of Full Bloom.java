class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = growTime.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[] {plantTime[i], growTime[i]};
        }
        Arrays.sort(arr, (a, b) -> b[1] - a[1]);
        int result = 0;
        for (int i = 0, currTime = 0; i < arr.length; i++) {
            int[] res = arr[i];
            result = Math.max(result, currTime + res[0] + res[1]);
            currTime += res[0];
        }
        return result;
    }
}
