/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package career;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author 17864
 */
public class Recursion__HanoiTower {

    private static final int NUM_PEGS = 3;

    public static void main(String[] args) {
        int rings = 6;
        List<Deque<Integer>> pegs = new ArrayList<>();

        for (int i = 0; i < NUM_PEGS; i++) {
            pegs.add(new LinkedList<>());
        }

        for (int i = rings; i >= 0; --i) {
            pegs.get(0).addFirst(i);
        }

        computeTowerHanoiSteps(rings, pegs, 0, 1, 2);
    }

    private static void computeTowerHanoiSteps(int numRingsToMove, List<Deque<Integer>> pegs, int fromPeg, int toPeg, int usePeg) {

        if (numRingsToMove > 0) {
            computeTowerHanoiSteps(numRingsToMove - 1, pegs, fromPeg, usePeg, toPeg);

            pegs.get(toPeg).addFirst(pegs.get(fromPeg).removeFirst());

            System.out.println("Move from Peg " + fromPeg + " to Peg " + toPeg);

            computeTowerHanoiSteps(numRingsToMove - 1, pegs, usePeg, toPeg, fromPeg);
        }
    }
}
