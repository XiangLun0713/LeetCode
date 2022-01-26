class Solution {
    public int romanToInt(String s) {
        String romanOrder = "IVXLCDM";
        ArrayList<String> seperatedRoman = new ArrayList<>();

        int result = 0;
        while (s.length() != 0 && s.length() != 1) {
            int currentCharValue = romanOrder.indexOf(s.charAt(0));
            int nextCharValue = romanOrder.indexOf(s.charAt(1));

            if (currentCharValue < nextCharValue) {
                seperatedRoman.add(s.substring(0, 2));
                s = s.substring(2);
            } else {
                seperatedRoman.add(String.valueOf(s.charAt(0)));
                s = s.substring(1);
            }
        }

        for (var res : seperatedRoman) {
            result += romanValueConverter(res);
        }
        if (s.length() == 1) {
            result += romanValueConverter(String.valueOf(s.charAt(0)));
        }
        return result;
    }
    
        private static int romanValueConverter(String s) {
        switch (s) {
            case "I" -> {
                return 1;
            }
            case "V" -> {
                return 5;
            }
            case "X" -> {
                return 10;
            }
            case "L" -> {
                return 50;
            }
            case "C" -> {
                return 100;
            }
            case "D" -> {
                return 500;
            }
            case "M" -> {
                return 1000;
            }
            case "IV" -> {
                return 4;
            }
            case "IX" -> {
                return 9;
            }
            case "XL" -> {
                return 40;
            }
            case "XC" -> {
                return 90;
            }
            case "CD" -> {
                return 400;
            }
            case "CM" -> {
                return 900;
            }
            default -> {
                return 0;
            }
        }
    }
}
