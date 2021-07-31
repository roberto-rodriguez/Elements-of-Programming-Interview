/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package career;
 
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author 17864
 */
public class Stack__TestStringOver {
      public static Map<Character, Character> OPOSITS = new HashMap<>();

    static {
        OPOSITS.put('[', ']');
        OPOSITS.put('{', '}');
        OPOSITS.put('(', ')');
    }

    public static void main(String[] args) {
        String s = "[()[]{()()}]";

        System.out.println(test(s));
    }

    public static boolean test(String s) {
        char[] array = s.toCharArray();

        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < array.length; i++) {
            Character ch = array[i];

            if (OPOSITS.containsKey(ch)) {
                stack.push(ch);
            } else {
                if (ch.equals(OPOSITS.get(stack.peek()))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }
}
