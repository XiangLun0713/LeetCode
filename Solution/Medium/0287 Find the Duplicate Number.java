class Solution {
    public int findDuplicate(int[] nums) {
        int tortoise = 0, hare = 0;
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        tortoise = 0;
        while (nums[tortoise] != nums[hare]) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return (nums[hare]);
    }
}
