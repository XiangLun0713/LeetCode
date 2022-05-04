/*
O(N log N) time complexity method using sorting and two pointer

Pseudocode:
1. Sort the array
2. Set up two pointers starting from the start and the end of the sorted array that move towards the middle
3. Calculate the sum of the elements pointed by the pointers
4. if sum == k, we know that we can remove the elements pointed by the pointers, but don't remove them, count instead
   if sum < k, increment i, in order to give a greater sum
   if sum > k, decrement j, in order to give a smaller sum
*/

class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1, count = 0;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum > k) {
                j--;
            } else if (sum < k) {
                i++;
            } else {
                count++;
                i++;
                j--;
            }
        }
        return count;
    }
}
