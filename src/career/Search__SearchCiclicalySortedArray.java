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
public class Search__SearchCiclicalySortedArray {

    public static void main(String[] args) {
        System.out.println(search(new int[]{378, 478, 550, 631, 103, 203, 220, 234, 279, 368}));
        System.out.println(search(new int[]{103, 203, 220, 234, 279, 368, 378, 478, 550, 631}));
        System.out.println(search(new int[]{903, 103, 203, 220, 234, 279, 368, 378, 478, 550, 631}));
    }

    public static int search(int[] array) {
        int start = 0, end = array.length - 1, middle = -1;
//        int first = array[0];
//        int last = array[array.length - 1];

        while (start <= end) {
            middle = start + (end - start) / 2;

            int previous = Integer.MIN_VALUE;
            int current = array[middle];
            int next = Integer.MAX_VALUE;

            if (middle > 0) {
                previous = array[middle - 1];
            }

            if (middle < array.length - 1) {
                next = array[middle + 1];
            }

            if (current < previous && current < next) {
                break;
            } else {
                if (current > array[start] && current < array[end]) {
                    return 0; //Corner case when is all ordered
                } else {
                    if (current > array[end]) {
                        start = middle + 1;
                    } else {
                        end = middle - 1;
                    }
                }
            }
        }

        return middle;
    }
}
