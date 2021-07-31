/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package career;

import java.util.Arrays;

/**
 *
 * @author 17864
 */
public class P__6_5__Arrays__Remove_a_Key {

    public static void main(String[] args) {
        int[] array = new int[]{5, 3, 7, 11, 2, 3, 13, 5, 7};

        System.out.println(removeKey(array, 3));

        System.out.println(Arrays.toString(array));
    }

    public static int removeKey(int[] array, int key) {

        int index = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != key) {
                array[index++] = array[i];
            }
        }

        for (int i = index; i < array.length; i++) {
            array[i] = 0;
        }

        return index;
    }
}
