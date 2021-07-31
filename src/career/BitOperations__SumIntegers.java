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
public class BitOperations__SumIntegers {

    public static void main(String[] args) {

//       b(4);
//       b(4>>>1); 
        s(11);
        s(1);
        s(11);
//        s(10);
//        s(~10);
//        s(11 & ~10);
//        s(5);
//        s(4); 
//        parity(7);
//        System.out.println(sum(7, 3));
   //     System.out.println(sum(7, 3));
    }
 

    public static int sum(int a, int b) {
        int carry = a & b;

        int result = a ^ b;

        if (carry == 0) {
            return result;
        } else {
            carry <<= 1;
            return sum(result, carry);
        }
    }
 

    public static String b(Integer value) {
        return String.format("%8s", Integer.toBinaryString(value)).replace(' ', '0'); // System.out.println();;
    }

    public static void s(Integer value) {
        System.out.println(String.format("%8s", Integer.toBinaryString(value)).replace(' ', '0'));
    }
}
