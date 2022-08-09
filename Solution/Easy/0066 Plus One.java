class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] arr = new int[n + 1];
        System.arraycopy(digits, 0, arr, 1, n);
        
        int index = n;
        while (++arr[index] == 10) {
            arr[index] = 0;
            index--;

        }
        
        return arr[0] != 0 ? arr : Arrays.copyOfRange(arr, 1, n + 1);
    }
}
