/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package career;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author 17864
 */
public class P__6_2__Arrays_IncrementArbitraryPrecitionNumber {

    public static void main(String[] args) {
        System.out.println(increment(Arrays.asList(1, 2, 8)));
        System.out.println(increment(Arrays.asList(1, 2, 9)));
        System.out.println(increment(Arrays.asList(1, 3, 0)));
        List<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(9);
        list.add(9);
        System.out.println(increment(list));
    }

    public static List increment(List<Integer> number) {

        int increment = 0;

        int pos = number.size() - 1;

        do {
            int n;
            
            if (pos < 0) {
                n = number.get(0);
            } else {
                n = number.get(pos);
            }

            n++;

            if (pos >= 0) {
                number.set(pos, n % 10);

                pos--;
            } else {
                number.add(0, n % 10);
            }

            increment = n / 10;
        } while (increment == 1);

        return number;
    }

}
