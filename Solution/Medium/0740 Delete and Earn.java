class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] arr = new int[10000];
        ArrayList<Integer> list = new ArrayList<>();
        for (int res : nums) {
            arr[res]++;
            if (!list.contains(res)) {
                list.add(res);
            }
        }
        Collections.sort(list);

        int earn1 = 0, earn2 = list.get(0) * arr[list.get(0)];
        for (int i = 1; i < list.size(); i++) {
            int temp;
            if (list.get(i - 1) == list.get(i) - 1) {
                temp = Math.max(earn1 + list.get(i) * arr[list.get(i)], earn2);
            } else {
                temp = earn2 + list.get(i) * arr[list.get(i)];
            }
            earn1 = earn2;
            earn2 = temp;
        }
        return earn2;
    }
}
