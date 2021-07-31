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
public class Search__BinarySearch_IndexOfElementBigerThan_K {

    public static void main(String[] args) {
        int[] array = new int[]{-14, -10, 2, 108, 108, 243, 285, 285, 285, 401};

        doBSearch(array, 285);
//        doBSearch(array, -13);
//        doBSearch(array, 450);
    }

    public static void doBSearch(int[] array, int k) {
        System.out.println(k + " -> " + bSearch(array, 0, array.length, k));
    }

    public static int bSearch(int[] array, int start, int end, int k) {

        int middle = start + ((end - start) / 2);

        System.out.println("bSearch start = " + start + ", end = " + end + ", middle = " + middle);

        if (start > end) {
            return nextIndex(array, start, k);
        }

        if (start == end || array[middle] == k) {
            return nextIndex(array, middle, k);
        } else {

            if (array[middle] < k) {
                return bSearch(array, middle + 1, end, k);
            } else { //if > k
                return bSearch(array, start, middle - 1, k);
            }
        }
    }

    public static int nextIndex(int[] array, int index, int k) {
        if (index < array.length && array[index] > k) {
            return index;
        } else {
            if (++index < array.length) {
                return nextIndex(array, index, k);
            } else {
                return -1;
            }
        }
    }
}
