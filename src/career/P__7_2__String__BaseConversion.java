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
public class P__7_2__String__BaseConversion {

    public static void main(String[] args) throws Exception {
        calc("615", 7, 13);
        calc("1A7", 13, 7);
    }

    public static void calc(String s, int baseFrom, int baseTo) throws Exception {
        System.out.println("Calc: " + s + " from " + baseFrom + " to " + baseTo);
        int decimal = toDecimal(s, baseFrom);
        System.out.println("decimal = " + decimal);
        System.out.println("result = " + fromDecimal(decimal, baseTo));
    }

    public static int toDecimal(String s, int base) throws Exception {
        int n = 0;
        for (int i = s.length() - 1, pow = 0; i >= 0; i--, pow++) {
            n += letterToInt(s.charAt(i)) * Math.pow(base, pow);//TODO Accept letters
        }
        return n;
    }
  
    public static String fromDecimal(int n, int base) {
        int pow = 0;

        while (16 * Math.pow(base, pow) < n) {
            pow++;
        }

        StringBuilder sb = new StringBuilder();

        while (pow >= 0) {
            int factor = (int) Math.pow(base, pow--);

            sb.append(intToLetter(n / factor));

            n %= factor;
        }

        return sb.toString();
    }

    private static String intToLetter(int n) {
        String letter = "";
        switch (n) {
            case 10:
                letter = "A";
                break;
            case 11:
                letter = "B";
                break;
            case 12:
                letter = "C";
                break;
            case 13:
                letter = "D";
                break;
            case 14:
                letter = "E";
                break;
            case 15:
                letter = "F";
                break;
            case 16:
                letter = "G";
                break;
            default:
                letter = n + "";
        }
        return letter;
    }

    private static int letterToInt(char ch) throws Exception {
        if (Character.isDigit(ch)) {
            return Integer.parseInt(ch + "");
        } else {
            switch (ch) {
                case 'A':
                    return 10;
                case 'B':
                    return 11;
                case 'C':
                    return 12;
                case 'D':
                    return 13;
                case 'E':
                    return 14;
                case 'F':
                    return 15;
                case 'G':
                    return 16;
                default:
                    throw new Exception("Invalid number " + ch);
            }
        }
    }
}
