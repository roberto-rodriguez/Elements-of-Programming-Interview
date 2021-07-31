/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package career;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 17864
 */
public class Recursion__Permutations2 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        List<List<String>> permutations = permutations(list);

        for (List<String> permutation : permutations) {
            System.out.println(permutation);
        }
    }

    public static List<List<String>> permutations(List<String> list) {
        List<List<String>> permutations = new ArrayList<>();
        if (list.size() == 0) {
            permutations.add(new ArrayList());
        } else {
            String elem = list.get(0);

            List<List<String>> result = permutations(list.subList(1, list.size()));

            for (List<String> perm : result) {
                permutations.add(perm);

                for (int i = 0; i <= perm.size(); i++) {
                    List<String> permutation = new ArrayList<>(perm);

                    permutation.add(i, elem);

                    permutations.add(permutation);
                }

            }

        }

        return permutations;
    }
}
