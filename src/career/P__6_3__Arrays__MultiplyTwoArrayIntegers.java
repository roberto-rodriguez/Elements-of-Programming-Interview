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
public class P__6_3__Arrays__MultiplyTwoArrayIntegers {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {4, 5};

        int[] result = multiply(a, b);

        print(result);
    }

    public static int[] multiply(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = 0;
        }

        for (int i = a.length - 1, ii = 0; i >= 0; i--, ii++) {
            for (int j = b.length - 1, jj = 0; j >= 0; j--, jj++) {

                increase(result, ii + jj, a[i] * b[j]);
            }
        }

        for (int i = 0; i < result.length / 2; i++) {
            int temp = result[i];
            result[i] = result[result.length - i - 1];
            result[result.length - i - 1] = temp;
        }

        return result;
    }

    public static void increase(int[] result, int index, int increase) {
        int sum = result[index] + increase;

        result[index] = sum % 10;

        if (sum / 10 > 0) {
            increase(result, ++index, sum / 10);
        }
    }

    private static void print(int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }
        System.out.println("");
    }
}
