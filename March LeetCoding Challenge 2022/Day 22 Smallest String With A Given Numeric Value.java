class Solution {
    public String getSmallestString(int n, int k) {
        char[] arr = new char[n];
        Arrays.fill(arr, 'a');
        k -= n;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (k >= 25) {
                arr[i] = (char) (arr[i] + 25);
                k -= 25;
            } else {
                arr[i] = (char) (arr[i] + k);
                break;
            }
        }
        return String.valueOf(arr);
    }
}
