class Solution {
    public boolean reorderedPowerOf2(int n) {
        char[] arr1 = String.valueOf(n).toCharArray();
        Arrays.sort(arr1);
        String s1 = String.valueOf(arr1);
        
        for (int i = 0; i < 31; i++) {
            char[] arr2 = String.valueOf((int) 1 << i).toCharArray();
            Arrays.sort(arr2);
            String s2 = String.valueOf(arr2);
            if (s1.equals(s2)) return true;
        }
        
        return false;
    }
}
