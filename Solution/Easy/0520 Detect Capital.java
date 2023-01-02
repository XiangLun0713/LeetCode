class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) return true;
        boolean firstIsCapital = Character.isUpperCase(word.charAt(0));
        boolean secondIsCapital = Character.isUpperCase(word.charAt(1));
        if (firstIsCapital) {
            if (secondIsCapital) {
                for (int i = 2; i < word.length(); i++) {
                    char curr = word.charAt(i);
                    if (!Character.isUpperCase(curr)) return false;
                }
            } else {
                for (int i = 2; i < word.length(); i++) {
                    char curr = word.charAt(i);
                    if (Character.isUpperCase(curr)) return false;
                }
            }
        } else {
            for (int i = 0; i < word.length(); i++) {
                char curr = word.charAt(i);
                if (Character.isUpperCase(curr)) return false;
            }
        }
        return true;
    }
}
