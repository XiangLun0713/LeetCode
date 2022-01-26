import java.util.ArrayList;
import java.util.List;

class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                list.add(Math.abs(i - start));
            }
        }
        int value = list.get(0);
        for (int res : list) {
            if (res < value) {
                value = res;
            }
        }
        return value;
    }
}
