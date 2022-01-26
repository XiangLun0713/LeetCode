class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        int[] arr = nums.clone();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                result.add(i);
            }
        }
        return result;
    }
}
