package dev.jessehaniel;

public class IntegerToRoman {

    // Given an integer, convert it to a roman numeral.

    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        // Loop through each symbol, stopping if num becomes 0.
        for (int i = 0; i < values.length && num > 0; i++) {
            // Repeat while the current symbol still fits into num.
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var app = new IntegerToRoman();
        var output = app.intToRoman(3);
        System.out.println(output);//III
        output = app.intToRoman(4);
        System.out.println(output);//IV
        output = app.intToRoman(9);
        System.out.println(output);//IX
        output = app.intToRoman(58);
        System.out.println(output);//LVIII
        output = app.intToRoman(1994);
        System.out.println(output);//MCMXCIV
    }

}
