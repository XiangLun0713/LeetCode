class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // decreasing monotonic stack
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                hashMap.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = hashMap.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}
