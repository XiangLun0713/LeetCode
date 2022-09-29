class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0, high = arr.length - k;
        while (low < high) {
            int mid = (low + high) / 2;
            if (x - arr[mid] > arr[mid + k] - x)
                low = mid + 1;
            else
                high = mid;
        }
        return Arrays.stream(arr, low, low + k).boxed().collect(Collectors.toList());
    }
}
