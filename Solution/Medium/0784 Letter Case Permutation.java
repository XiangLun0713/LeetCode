class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        findPermutation(result, 0, s);
        return result;
    }

    private void findPermutation(List<String> result, int i, String s) {
        if (i < s.length()) {
            if (Character.isLetter(s.charAt(i))) {
                s = s.substring(0, i) + Character.toLowerCase(s.charAt(i)) + s.substring(i + 1);
                findPermutation(result, i + 1, s);
                s = s.substring(0, i) + Character.toUpperCase(s.charAt(i)) + s.substring(i + 1);
                findPermutation(result, i + 1, s);
            } else {
                findPermutation(result, i + 1, s);
            }
        } else {
            result.add(s);
        }
    }
}
