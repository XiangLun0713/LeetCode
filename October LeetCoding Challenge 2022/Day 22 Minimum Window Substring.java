class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> target = new HashMap<>();
        for (char c : t.toCharArray()) target.put(c, target.getOrDefault(c, 0) + 1);
        int left = 0, count = 0, minLeft = 0, minLen = s.length() + 1;
        for (int right = 0; right < s.length(); right++) {
            char cRight = s.charAt(right);
            if (!target.containsKey(cRight)) continue;
            target.put(cRight, target.get(cRight) - 1);
            if (target.get(cRight) >= 0) count++;
            while (count == t.length()) {
                char cLeft = s.charAt(left);
                if (right - left + 1 < minLen) {
                    minLeft = left;
                    minLen = right - left + 1;
                }
                if (target.containsKey(cLeft)) {
                    target.put(cLeft, target.get(cLeft) + 1);
                    if (target.get(cLeft) > 0) count--;
                }
                left++;
            }
        }
        return (minLen <= s.length()) ? s.substring(minLeft, minLeft + minLen) : "";
    }
}
