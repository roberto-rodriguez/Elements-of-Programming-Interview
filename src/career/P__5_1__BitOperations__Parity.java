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
public class P__5_1__BitOperations__Parity {

    public static void main(String[] args) {

        parity(7);
    }

    public static void parity(Integer v) {
        short result = 0;
        while (v != 0) {
            System.out.println(b(v));
            result ^= (v & 1);

            v >>>= 1;
        }

        System.out.println("result = " + result);
    }

    public static String b(Integer value) {
        return String.format("%8s", Integer.toBinaryString(value)).replace(' ', '0'); // System.out.println();;
    }

    public static void s(Integer value) {
        System.out.println(String.format("%8s", Integer.toBinaryString(value)).replace(' ', '0'));
    }
}
