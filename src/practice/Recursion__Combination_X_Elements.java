/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author 17864
 */
public class Recursion__Combination_X_Elements {

    public static void main(String[] args) {
        System.out.println(combinations(5, 2));
    }

    public static List<List<Integer>> combinations(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();

        backtracking(n, k, 1, new ArrayList<>(), combinations);

        return combinations.stream()
                .filter(c -> c.size() == k)
                .collect(Collectors.toList());
    }

    public static void backtracking(int n, int k, int start, List<Integer> current, List<List<Integer>> combinations) {

        if (current.size() == k) {
            combinations.add(new ArrayList(current));
        } else {
            for (int i = start; i <= n && current.size() < k; i++) {
                current.add(i);
                backtracking(n, k, i + 1, current, combinations);
                current.remove(current.size() - 1);
            }
        }
    }
}
