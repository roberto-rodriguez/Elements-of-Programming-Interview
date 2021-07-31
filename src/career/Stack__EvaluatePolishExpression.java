/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package career;

import java.util.Deque;
import java.util.Stack;

/**
 *
 * @author 17864
 */
public class Stack__EvaluatePolishExpression {

    public static void main(String[] args) {
        System.out.println(polish(new String[]{"3", "4", "+", "2", "*", "1", "+"}));
    }

    public static Integer polish(String[] exp) {
        Stack<Integer> stack = new Stack<>();

        for (String s : exp) {
            switch (s) {
                case "+":
                case "-":
                case "*":
                case "/":
                    stack.push(evaluate(s, stack.pop(), stack.pop()));
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }

    public static int evaluate(String symbol, int a, int b) {
        switch (symbol) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return 0;
        }

    }

}
