class Solution {
    public void moveZeroes(int[] nums) {
        ArrayList<Integer> buffer = new ArrayList<>();
        for (int res : nums) {
            if (res != 0) {
                buffer.add(res);
            }
        }
        System.arraycopy(buffer.stream().mapToInt(Integer::intValue).toArray(), 0, nums, 0, buffer.size());
        Arrays.fill(nums, buffer.size(), nums.length, 0);
    }
}
