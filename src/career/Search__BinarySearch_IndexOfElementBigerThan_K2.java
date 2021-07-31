/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package career;

import static career.Search__BinarySearch_IndexOfElementBigerThan_K.bSearch;
import static career.Search__BinarySearch_IndexOfElementBigerThan_K.doBSearch;

/**
 *
 * @author 17864
 */
public class Search__BinarySearch_IndexOfElementBigerThan_K2 {

    public static void main(String[] args) {
        int[] array = new int[]{-14, -10, 2, 108, 108, 243, 285, 285, 285, 401};

//        doBSearch(array, 285);
//        doBSearch(array, -13);
        doBSearch(array, 450);
    }

    public static void doBSearch(int[] array, int k) {
        System.out.println(k + " -> " + bSearch(array, k));
    }

    public static int bSearch(int[] array, int k) {
        int result = -1;
        int middle = 0;
        int start = 0, end = array.length;

        while (start <= end) {
            middle = start + (end - start) / 2;

            if (middle == array.length) {
                return -1;
            }

            if (array[middle] <= k) {
                start = middle + 1;
            } else {
                result = middle;
                end = middle - 1;
            }
        }
        return result;
    }
}
