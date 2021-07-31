/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package career;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author 17864
 */
public class P__6_4__Arrays__CanReachEnd {

    public static void main(String[] args) {
        System.out.println(minimumStepsToReachEnd(new int[]{3, 3, 1, 0, 2, 0, 1}));
//        System.out.println(canReachEnd(new int[]{3, 3, 1, 0, 2, 0, 1}));
//        System.out.println(canReachEnd(new int[]{3, 2, 0, 0, 2, 0, 1}));
    }

    public static int minimumStepsToReachEnd(int[] A) {

        for (int i = A.length - 1; i >= 0; i--) {
            if (i == A.length - 1) {
                continue;
            }

            int n = A[i];

            int targetIndex = i + n;

            boolean canPlay = false;

            int minSteps = Integer.MAX_VALUE;

            for (int j = i + 1; j <= targetIndex; j++) {
                if (j < A.length && A[j] != 0) {
                    canPlay = true;

                    if (A[j] < minSteps) {
                        minSteps = A[j];
                    }
                }
            }

            if (!canPlay) {
                A[i] = 0;
            } else {
                A[i] = minSteps + 1;
            }
        }

        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + ", ");
        }
        System.out.println("");
        return A[0];
    }

    public static boolean canReachEnd(int[] A) {

        for (int i = A.length - 1; i >= 0; i--) {
            int n = A[i];

            int targetIndex = i + n;

            boolean canPlay = false;

            for (int j = i + 1; j <= targetIndex; j++) {
                if (j < A.length && A[j] != 0 || i == A.length - 1) {
                    canPlay = true;
                }
            }

            if (!canPlay) {
                A[i] = 0;
            }
        }

        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + ", ");
        }
        System.out.println("");
        return A[0] > 0;
    }
}
