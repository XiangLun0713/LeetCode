class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] arr = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < mat.length; i++) {
            pq.offer(new int[]{findSoldiers(mat[i]), i});
        }
        for (int i = 0; i < k; i++) {
            int[] res = pq.poll();
            arr[i] = res[1];
        }
        return arr;
    }

    private int findSoldiers(int[] arr) {
        return findHigh(arr) + 1;
    }

    private int findHigh(int[] arr) {
        int high = arr.length - 1;
        int low = 0;
        while (high >= low) {
            int mid = low + (high - low) / 2;
            if (mid == arr.length - 1 || arr[mid + 1] != 1 && arr[mid] == 1) {
                return mid;
            } else if (arr[mid] == 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
