/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package career;

/**
 *
 * @author 17864
 */
public class P__7_1__String__StringToInteger {

    public static void main(String[] args) {
        System.out.println(intToString(231));
        System.out.println(intToString(-2231));
//        System.out.println(stringToInt("231"));
//        System.out.println(stringToInt("-2231"));
    }

    public static int stringToInt(String s) {
        int n = 0, sign = 1;

        if (s.charAt(0) == '-') {
            sign = -1;
            s = s.substring(1);
        }

        for (int i = 0; i < s.length(); i++) {
            n += (s.charAt(s.length() - 1 - i) - '0') * Math.pow(10, i);
        }
        return sign * n;
    }

    public static String intToString(int n) {
        String s = "", sign = "";

        if (n < 0) {
            n *= -1;
            sign = "-";
        }

        while (n > 0) {
            s = n % 10 + s;
            n /= 10;
        }

        return sign + s;
    }
}
