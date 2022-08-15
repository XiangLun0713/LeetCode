class Solution {
    public int romanToInt(String s) {
        s = s.replace("IV", "IIII");
        s = s.replace("IX", "VIIII");
        s = s.replace("XL", "XXXX");
        s = s.replace("XC", "LXXXX");
        s = s.replace("CD", "CCCC");
        s = s.replace("CM", "DCCCC");
        
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += mapRomanCharToInt(c);
        }
        return sum;
    }
    
    private int mapRomanCharToInt(char c) {
        return switch(c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D'-> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}
