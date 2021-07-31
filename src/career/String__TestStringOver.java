/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package career;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 17864
 */
public class String__TestStringOver {



     public static Map<Character, Character> OPOSITS = new HashMap<>();

    static {
        OPOSITS.put('[', ']');
        OPOSITS.put('{', '}');
        OPOSITS.put('(', ')');
    }

    public static void main(String[] args) {
        String s = "[()[]{()()}]";

        System.out.println(validate(s));
    }

    public static boolean validate(String s) {
        char[] array = s.toCharArray();

        int leftPosition = 0;
        int rightPosition = 0;

        do {
            char left = array[leftPosition];

            rightPosition = getRightPosition(array, left, rightPosition + 1);

            leftPosition = rightPosition + 1;
        } while (rightPosition != -1 && rightPosition < array.length - 1);

        return rightPosition == array.length - 1;
    }

    public static int getRightPosition(char[] array, char left, int index) {
        if (index >= array.length) {
            return -1;
        }

        char next = array[index];

        if (OPOSITS.containsKey(left)) {
            if (next == OPOSITS.get(left)) {
                return index;
            } else {
                int rightPosition = getRightPosition(array, next, index + 1);

                if (rightPosition == -1) {
                    return -1;
                } else {
                    return getRightPosition(array, left, rightPosition + 1);
                }
            }
        } else {
            return -1;
        }

    }
}
