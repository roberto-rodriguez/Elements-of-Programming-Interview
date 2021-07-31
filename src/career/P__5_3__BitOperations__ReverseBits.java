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
public class P__5_3__BitOperations__ReverseBits {

    public static void main(String[] args) {
        s(27);
        s(27 ^ 0XFF);
         
//        swap(47, 3, 4);
      //  System.out.println(swap(54, 3, 4));;

    }

   
    public static String b(Integer value) {
        return String.format("%8s", Integer.toBinaryString(value)).replace(' ', '0'); // System.out.println();;
    }

    public static void s(Integer value) {
        System.out.println(String.format("%8s", Integer.toBinaryString(value)).replace(' ', '0'));
    }
}
