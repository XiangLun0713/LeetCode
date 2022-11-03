class Solution {
    public int longestPalindrome(String[] words) {
        Set<String> visited = new HashSet<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String word : words) {
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
        }

        int count = 0;
        boolean flag = false;
        for (String key : hashMap.keySet()) {
            if (visited.contains(key)) continue;
            if (isPalindrome(key)) {
                visited.add(key);
                int val = hashMap.get(key);
                if (isEven(val)) {
                    count += val;
                } else {
                    count += val - 1;
                    flag = true;
                }
                continue;
            }

            String reverseKey = reverseString(key);
            if (hashMap.containsKey(reverseKey)) {
                int minCount = Math.min(hashMap.get(reverseKey), hashMap.get(key));
                visited.add(reverseKey);
                visited.add(key);
                count += (minCount * 2);
            }
        }

        return flag ? (count + 1) * 2 : count * 2;    
    }
    
    private boolean isEven(int n) {
        return (n % 2 == 0);
    }
    
    private boolean isPalindrome(String s) {
        return s.charAt(0) == s.charAt(1);
    }
    
    private String reverseString(String s) {
        return "" + s.charAt(1) + s.charAt(0);
    }
}
