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
public class DynamicProgramming__CombinationsToScore {
    //Given that scores can be 2, 3, or 7
    //Find all possible combinations for a give score

    public static void main(String[] args) {
        int[] calls = new int[1];
        calls[0] = 0;

//        for (int i = 0; i < 22; i++) {
//            System.out.println(i + " - " + combinations(i));
//        }
        int n = 20;
        int[] cache = new int[n];

        for (int i = 0; i < n; i++) {
            cache[i] = 0;
        }
        System.out.println(n + " - " + combinations(n, cache, calls) + " -> " + calls[0]);

        //20 - 232 -> 685
    }

    public static int combinations(int score, int[] cache, int[] calls) {
         
        if (score > 0 && cache[score - 1] != 0) {
            return cache[score - 1];
        }

        calls[0]++;

        int n = 0;

        if (score < 2) {
            n = 0;
        } else {
            if (score == 2 || score == 3 || score == 7) {
                n = 1;
            }
        }

        if (score > 3) {
            n += combinations(score - 2, cache, calls) + combinations(score - 3, cache, calls) + combinations(score - 7, cache, calls);
        }

        if (score > 0) {
            cache[score - 1] = n;
        }

        return n;
    }
}
