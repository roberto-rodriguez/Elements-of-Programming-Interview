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
public class Greedy__The_3_sum_problem {

    public static void main(String[] args) {
        int array[] = {11, 2, 5, 7, 3};

        System.out.println(sum(array, 21, 1, 0));
    }

    public static boolean sum(int[] array, int n, int position, int index) {
        if (position == 3) {
            return array[index] == n;
        }

        for (int i = 0; i < array.length; i++) {
            if (sum(array, n - array[i], position + 1, i)) {
                return true;
            }
        }
        return false;
    }
}
