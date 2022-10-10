class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n < 2) return "";
        char[] arr = palindrome.toCharArray();
        boolean replaceChar = false;
        for (int left = 0; left < n / 2; left++) {
            if (arr[left] == 'a') continue;
            arr[left] = 'a';
            replaceChar = true;
            break;
        }
        if (!replaceChar) arr[arr.length - 1]++;
        return String.valueOf(arr);
    }
}
