class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        // sort the array
        Arrays.sort(properties, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : b[0] - a[0]);
        
        int count = 0;
        int maxDefense = properties[0][1];
        for (int i = 1; i < properties.length; i++) {
            if (properties[i][1] >= maxDefense) {
                maxDefense = properties[i][1];        
            } else {
                count++;
            }
        }
        
        return count;
    }
}
