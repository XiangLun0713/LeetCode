class Solution {
    public int[] movesToStamp(String stamp, String target) {
        char[] stampArr = stamp.toCharArray();
        char[] targetArr = target.toCharArray();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[targetArr.length];
        int starCount = 0;
        boolean hasProgress = false;
        
        while (starCount != targetArr.length) {
            hasProgress = false;
            for (int i = 0; i < targetArr.length - stampArr.length + 1; i++) {
                if (!visited[i] && canReplace(i, stampArr, targetArr)) {
                    starCount = replace(i, stampArr, targetArr, starCount);
                    visited[i] = true;
                    list.add(i);
                    hasProgress = true;
                    
                    if (starCount == targetArr.length) break;
                }
            }
            
            if (!hasProgress) return new int[0];
        }
        
        int[] result = new int[list.size()];
        for (int i = list.size() - 1, j = 0; i >= 0; i--) {
            result[j++] = list.get(i);
        }
        
        return result;
    }
    
    private boolean canReplace(int startIndex, char[] stampArr, char[] targetArr) {
        for (int i = 0; i < stampArr.length; i++) {
            if (targetArr[startIndex + i] != '?' && targetArr[startIndex + i] != stampArr[i]) 
                return false;
        }
        return true;
    }
    
    private int replace(int startIndex, char[] stampArr, char[] targetArr, int starCount) {
        for (int i = 0; i < stampArr.length; i++) {
            if (targetArr[startIndex + i] != '?') {
                targetArr[startIndex + i] = '?';
                starCount++;
            }
        }
        return starCount;
    }
}
