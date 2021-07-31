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
public class BinaryTree__SumRootToPath {

    public static void main(String[] args) {
        List<String> numbers = new ArrayList<>();
        System.out.println(sum(buildTree(), 0, 0, numbers));

        System.out.println(numbers);
    }

    public static int sum(BTree<Integer> tree, int number, int sum, List<String> numbers) {
        number += tree.getValue();

        if (tree.left == null && tree.right == null) {
            numbers.add(b(number));
            return number;
        } else {
            if (tree.left != null) {
                sum += sum(tree.left, number << 1, sum, numbers);
            }
            if (tree.right != null) {
                sum += sum(tree.right, number << 1, sum, numbers);
            }
        }
        return sum;
    }

    public static String b(Integer value) {
        return String.format("%8s", Integer.toBinaryString(value)).replace(' ', '0'); // System.out.println();;
    }

    private static BTree<Integer> buildTree() {
        BTree<Integer> M = new BTree<>(1);
        BTree<Integer> N = new BTree<>(0);
        BTree<Integer> L = new BTree<>(1, null, M);

        BTree<Integer> K = new BTree<>(0, L, N);

        BTree<Integer> J = new BTree<>(0, null, K);

        BTree<Integer> P = new BTree<>(0);
        BTree<Integer> O = new BTree<>(0, null, P);
        BTree<Integer> I = new BTree<>(1, J, O);

        BTree<Integer> H = new BTree<>(0);
        BTree<Integer> G = new BTree<>(1, H, null);
        BTree<Integer> F = new BTree<>(1, null, G);

        BTree<Integer> E = new BTree<>(1);
        BTree<Integer> D = new BTree<>(0);
        BTree<Integer> C = new BTree<>(0, D, E);
        BTree<Integer> B = new BTree<>(0, C, F);

        BTree<Integer> A = new BTree<>(1, B, I);
        return A;
    }
}
