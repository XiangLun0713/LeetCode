class NumArray {

    private int[] nums;
    private int[] fenwickTree;
    
    public NumArray(int[] nums) {
        this.nums = nums;
        fenwickTree = new int[nums.length + 1];
        System.arraycopy(nums, 0, fenwickTree, 1, nums.length);
        for (int i = 1; i < fenwickTree.length; i++) {
            int p = i + (i & -i);
            if (p < fenwickTree.length) {
                fenwickTree[p] += fenwickTree[i];
            }
        }
    }
    
    public void update(int index, int val) {
        int addAmount = val - nums[index];
        nums[index] = val;
        index++;
        while (index < fenwickTree.length) {
            fenwickTree[index] += addAmount;
            index += (index & -index);
        }
    }
    
    public int sumRange(int left, int right) {
        return cumulativeSum(right + 1) - cumulativeSum(left);
    }
    
    // return the cumulative sum from 0 till i
    private int cumulativeSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += fenwickTree[i];
            i -= (i & -i);
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
