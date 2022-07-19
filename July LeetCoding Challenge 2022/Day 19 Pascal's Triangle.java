class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(List.of(1)));
        
        int[] prevLevel = {1};
        for (int i = 0; i < numRows - 1; i++) {
            int[] newLevel = buildNewLevel(prevLevel);
            List<Integer> levelList = Arrays.stream(newLevel).boxed().toList();
            triangle.add(levelList);
            prevLevel = newLevel;
        }
        
        return triangle;
    }
    
    private int[] buildNewLevel(int[] prevLevel) {
        int[] temp = new int[prevLevel.length + 1];
        System.arraycopy(prevLevel, 0, temp, 1, prevLevel.length);
        for (int i = 0; i < temp.length - 1; i++) {
            temp[i] += prevLevel[i];
        }
        return temp;
    }
}
