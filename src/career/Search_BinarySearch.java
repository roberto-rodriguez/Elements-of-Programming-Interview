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
public class Search_BinarySearch {

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 4, 6, 7, 8, 9, 23};

        System.out.println("array.length = " + array.length);

//        System.out.println(bSearch(array, 9));

        for (int i = 0; i < array.length; i++) {
            System.out.println("Calling bSearch on " + array[i]);
            int pos = bSearch(array, array[i]);
            System.out.println(pos == i);
        }
    }

    public static int bSearch(int[] array, int n) {

        int start = 0;
        int end = array.length - 1;
        int middle = start + ((end - start) / 2);

        while (start <= end) {
            middle = start + ((end - start) / 2);

            int value = array[middle];

            if (value == n) {
                break;
            } else {
                if (n < value) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                } 
            }
        }

        return middle;
    }
}
