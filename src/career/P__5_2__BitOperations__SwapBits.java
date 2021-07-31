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
public class P__5_2__BitOperations__SwapBits {

    public static void main(String[] args) {
         
//        swap(47, 3, 4);
        System.out.println(swap(54, 3, 4));;

    }

    public static int swap(int n, int i, int j) {
        if (((n >>> i) & 1) != ((n >>> j) & 1)) {
            int mask = (1 << i) | (1 << j);
            System.out.println(b(n));
            n ^= mask;
            System.out.println(b(mask));
            System.out.println(b(n));
        }
        return n;
    }

    public static String b(Integer value) {
        return String.format("%8s", Integer.toBinaryString(value)).replace(' ', '0'); // System.out.println();;
    }

    public static void s(Integer value) {
        System.out.println(String.format("%8s", Integer.toBinaryString(value)).replace(' ', '0'));
    }
}
