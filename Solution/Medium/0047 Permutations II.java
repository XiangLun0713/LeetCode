class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        for (int i = 0; i < list.size(); i++) {
            List<Integer> temp = new ArrayList<>(list);
            List<Integer> path = new ArrayList<>();
            path.add(temp.remove(i));
            findPermute(temp, result, path);
        }
        return result;
    }

    private void findPermute(List<Integer> list, List<List<Integer>> result, List<Integer> prePath) {
        if (list.isEmpty()) {
            boolean addable = true;
            for (var res : result) {
                if (res.equals(prePath)) {
                    addable = false;
                    break;
                }
            }
            if (addable) {
                result.add(prePath);
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                List<Integer> temp = new ArrayList<>(list);
                List<Integer> path = new ArrayList<>(prePath);
                path.add(temp.remove(i));
                findPermute(temp, result, path);
            }
        }
    }
}
