class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < arr.length && !isVowel(arr[left])) {
                left++;
            }
            while (right >= 0 && !isVowel(arr[right])) {
                right--;
            }
            if (left >= right) break;
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(arr);
    }
    
    private boolean isVowel(char c) {
        char temp = Character.toLowerCase(c);
        return (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u');
    }
}
