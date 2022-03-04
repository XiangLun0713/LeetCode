class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        int[] preArr = {1};
        result.add(Arrays.stream(preArr).boxed().toList());
        for (int i = 1; i < numRows; i++) {
            int[] arr1 = new int[i + 1];
            System.arraycopy(preArr, 0, arr1, 0, preArr.length);
            int[] arr2 = new int[i + 1];
            System.arraycopy(preArr, 0, arr2, 1, preArr.length);
            int[] arr = addArrays(arr1, arr2);
            preArr = arr;
            result.add(Arrays.stream(arr).boxed().toList());
        }
        return result;
    }

    private int[] addArrays(int[] a, int[] b) {
        int[] arr = new int[a.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = a[i] + b[i];
        }
        return arr;
    }
}
