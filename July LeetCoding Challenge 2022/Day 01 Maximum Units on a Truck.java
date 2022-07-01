class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int result = 0;
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        
        for (int[] box : boxTypes) {
            if (truckSize >= box[0]) {
                result += box[0] * box[1];
                truckSize -= box[0];
            } else {
                result += truckSize * box[1];
                return result;
            }
        }
        return result;
    }
}
