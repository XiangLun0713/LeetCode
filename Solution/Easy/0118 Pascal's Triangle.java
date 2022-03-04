class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        int[] preArr = new int[0];
        for (int i = 0; i < numRows; i++) {
            int[] arr = new int[i + 1];
            arr[0] = 1;
            arr[i] = 1;
            for (int j = 1; j < i; j++) {
                arr[j] = preArr[j - 1] + preArr[j];
            }
            preArr = arr;
            result.add(new ArrayList<>(Arrays.stream(arr).boxed().toList()));
        }
        return result;
    }
}
