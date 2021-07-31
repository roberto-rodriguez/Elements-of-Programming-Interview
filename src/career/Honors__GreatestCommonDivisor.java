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
public class Honors__GreatestCommonDivisor {//Without using * , / , %
    //Naive solution:
    //Substract the minor value to the bigger value while possible then fing the GCD
    //
    //Solution:
    //Premises: 
    //- If A = B         : GCD(A,B) = A   
    //- If both are even : GCD(A,B) = 2 * GCD(A/2, B/2)
    //- If only A is even: GCD(A,B) = GCD(A/2, B)
    //- If only B is even: GCD(A,B) = GCD(A, B/2)
    //- If both are odd  : GCD(A,B) = GCD(A - B, B) (assumming A > B)

    public static void main(String[] args) {
        call(85, 15);
        call(86, 75);
//        call(7, 21);
//        call(7, 22);
//        call(7, 23);
//        call(7, 24);
//        call(8, 22);
//        call(8, 23);
//        call(8, 24);
    }

    public static void call(int A, int B) {
        System.out.println("GCD(" + A + "," + B + ") -> " + GCD(A, B));
    }

    public static long GCD(int A, int B) {
        if (A == B) {
            return A;
        } else {
            if ((A & 1) == 0 && (B & 1) == 0) {   //Both are even
                return (GCD(A >>> 1, B >>> 1)) << 1;
            } else {
                if ((A & 1) == 1 && (B & 1) == 0) { // A is odd
                    return (GCD(A, B >>> 1));
                } else {
                    if ((A & 1) == 0 && (B & 1) == 1) { //B is odd
                        return (GCD(A >>> 1, B));
                    } else {//Both are odd
                        if (A > B) {
                            return (GCD(A - B, B));
                        } else {
                            return (GCD(A, B - A));
                        }
                    }
                }
            }
        }
    }
}
