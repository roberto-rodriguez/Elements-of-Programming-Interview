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
public class Recursion__Combination_All_Elements {

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(0, 1, 2, 4);

        List<List<Integer>> combinations = combinations(input);

        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }

    public static List<List<Integer>> combinations(List<Integer> input) {
        List<List<Integer>> combinations = new ArrayList<>();

        if (input.size() == 0) {
            combinations.add(new ArrayList<>());
        } else {
            List<List<Integer>> result = combinations(input.subList(1, input.size()));

            combinations.addAll(result);

            for (List<Integer> comb : result) {
                List<Integer> combination = new ArrayList<>(comb);
                combination.add(0, input.get(0));
                combinations.add(combination);
            }
        }

        return combinations;
    }
}
