class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int result = 0;
        int num1 = tops[0];
        int num2 = bottoms[0];
        boolean possible = true;
        
        if (num1 != num2) {
            int top = 0, bottom = 0;
            boolean topPossible = true;
            boolean bottomPossible = true;
            
            // check top part
            for (int i = 0; i < tops.length; i++) {
                if (bottoms[i] != num1 && tops[i] != num1) {
                    topPossible = false;
                }
                if (bottoms[i] != num1){
                    bottom++;
                }
                if (tops[i] != num1) {
                    top++;
                }
            }
            
            result = Math.min(top, bottom);
            top = 0;
            bottom = 0;
            // check bottom part
            for (int i = 0; i < tops.length; i++) {
                if (bottoms[i] != num2 && tops[i] != num2) {
                    bottomPossible = false;
                }
                if (bottoms[i] != num2) {
                    bottom++;
                } 
                if (tops[i] != num2) {
                    top++;
                }
            }
            result = Math.min(result, Math.min(bottom, top));
            possible = topPossible || bottomPossible;
            return possible? result : -1;
            
        } else {
            int top = 0, bottom = 0;
            for (int i = 0; i < tops.length; i++) {
                if (bottoms[i] != num1 && tops[i] != num1) {
                    return -1;
                }
                if (bottoms[i] != num1){
                    bottom++;
                }
                if (tops[i] != num1) {
                    top++;
                }
            }
            return Math.min(bottom, top);
        }
    }
}
