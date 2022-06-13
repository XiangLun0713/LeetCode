class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] memoize = new int[triangle.get(triangle.size() - 1).size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            int[] temp = new int[triangle.get(i).size()];
            for (int j = 0; j < triangle.get(i).size(); j++) {
                temp[j] = triangle.get(i).get(j) + Math.min(memoize[j], memoize[j + 1]);
            }
            memoize = temp;
        }
        return memoize[0];
    }
}
