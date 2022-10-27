class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int numOfRows = img1.length;
        int numOfCols = img1[0].length;
        List<int[]> img1List = new ArrayList<>(), img2List = new ArrayList<>();
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfCols; j++) {
                if (img1[i][j] == 1) img1List.add(new int[] {i, j});
                if (img2[i][j] == 1) img2List.add(new int[] {i, j});
            }
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int[] arr1 : img1List) {
            for (int[] arr2 : img2List) {
                String s = (arr1[0] - arr2[0]) + " " + (arr1[1] - arr2[1]);
                hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
            }
        }
        int max = 0;
        for (Integer i : hashMap.values()) max = Math.max(max, i);
        return max;
    }
}
