class Solution {
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        String[] words = s.split(" ");
        for (String res : words) {
            char[] arr = res.toCharArray();
            for (int i = 0; i < arr.length / 2; i++) {
                char temp = arr[i];
                arr[i] = arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = temp;
            }
            builder.append(arr).append(" ");
        }
        return String.valueOf(builder).trim();
    }
}
