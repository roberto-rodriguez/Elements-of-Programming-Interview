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
public class P__7_3__String__SpreadsheetColumnEncoding {

    public static void main(String[] args) {
        encode("A");
        encode("Z");
        encode("AA");
        encode("ZZ");
        encode("AZZ");
        encode("AAA");
    }

    public static int encode(String code) {
        int sum = 0;

        for (int i = code.length() - 1, pow = 0; i >= 0; i--, pow++) {
            sum += (code.charAt(i) - 'A' + 1) * Math.pow(26, pow);
        }

        System.out.println("encode " + code + " = " + sum);

        return sum;
    }
}
