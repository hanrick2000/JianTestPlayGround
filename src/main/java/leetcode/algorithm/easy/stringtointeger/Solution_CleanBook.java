package leetcode.algorithm.easy.stringtointeger;

/**
 * Created by jshe18 on 8/19/15.
 */
public class Solution_CleanBook {
    private static final int maxDiv10 = Integer.MAX_VALUE / 10;

    public static int atoi(String str) {
        int i = 0, n = str.length();
        while (i < n && Character.isWhitespace(str.charAt(i))) i++;
        int sign = 1;
        if (i < n && str.charAt(i) == '+') {
            i++;
        } else if (i < n && str.charAt(i) == '-') {
            sign = -1;
            i++; }
        int num = 0;
        while (i < n && Character.isDigit(str.charAt(i))) {
            int digit = Character.getNumericValue(str.charAt(i));
            if (num > maxDiv10 || num == maxDiv10 && digit >= 8) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + digit;
            i++; }
        return sign * num;
    }

    public static void main(String[] args){
//        String input = "234";
//        String input = "234bcv";
//        String input = "-234";
//        String input = "-234bcv";
//        String input = "   ";
//        String input = "+234";
//        String input = "bc345";
//        String input = String.valueOf(Integer.MAX_VALUE);
        String input = "9223372036854775809";

        System.out.println(atoi(input));
    }

}
