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
public class P__5_5__BitOperations__MultiplyIntegers {

    public static void main(String[] args) {
        System.out.println(multiply(13, 9));
    }

    public static int multiply(int a, int b) {
        int sum = 0;

        while (b != 0) {
            if ((b & 1) == 1) {
                sum += a;
            }
            a <<= 1;
            b >>= 1;
        }

        return sum;
    }

    public static String b(Integer value) {
        return String.format("%8s", Integer.toBinaryString(value)).replace(' ', '0'); // System.out.println();;
    }

    public static void s(Integer value) {
        System.out.println(String.format("%8s", Integer.toBinaryString(value)).replace(' ', '0'));
    }
}
