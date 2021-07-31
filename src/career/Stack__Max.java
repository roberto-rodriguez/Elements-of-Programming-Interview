/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package career;

import java.util.LinkedList;

/**
 *
 * @author 17864
 */
public class Stack__Max {

    public static void main(String[] args) {
        StackWithMax stack = new StackWithMax();

        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.push(2);

        Integer max = stack.max();

        System.out.println("max = " + max);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}

class StackWithMax extends LinkedList<Integer> {

    public Integer max() {
        Integer max = 0;

        LinkedList<Integer> stack = new LinkedList<>();

        while (!isEmpty()) {
            Integer n = pop();

            if (n > max) {
                max = n;
            }

            stack.push(n);
        }

        while (!stack.isEmpty()) {
            push(stack.pop());
        }

        return max;
    }

}
