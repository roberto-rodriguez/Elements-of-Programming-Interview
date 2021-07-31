/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package career;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author 17864
 */
public class Recursion__Permutations {

//    public static void main(String[] args) {
//        List<Integer> A = Arrays.asList(1, 2, 3);
//
//        List<List<Integer>> result = new ArrayList<>();
//
//        permutations(0, A, result);
//
//        for (List<Integer> permutation : result) {
//            System.out.println(permutation);
//        }
//    }
//
//    public static void permutations(int i, List<Integer> A, List<List<Integer>> result) {
//        if (i == A.size() - 1) {
//            result.add(new ArrayList(A));
//        }
//
//        for (int j = i; j < A.size(); ++j) {
//            Collections.swap(A, i, j);
//
//            permutations(i + 1, A, result);
//
//            Collections.swap(A, i, j);
//        }
//    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);

        List<List<Integer>> permutations = new ArrayList<>();

        permutations(list, 0, permutations);

        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }

    public static void permutations(List<Integer> list, int index, List<List<Integer>> permutations) {
        if (index == list.size() - 1) {
            permutations.add(new ArrayList(list));
        }

        for (int i = index; i < list.size(); ++i) {
            Collections.swap(list, index, i);

            permutations(list, index + 1, permutations);

            Collections.swap(list, index, i);
        }
    }
}
