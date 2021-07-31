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
import java.util.stream.Collectors;

/**
 *
 * @author 17864
 */
public class Stack__Tree_without_recursion {

    public static void main(String[] args) {
        BTree<Integer> tree = buildTree();

//        System.out.println(tree.preOrder());
//        System.out.println(tree.inOrder());
//        System.out.println(tree.postOrder());
        List<BTree> preOrderSubTreeWithoutRecursion = preOrderSubTreeWithoutRecursion(tree, 37);
//        List<BTree> preOrderSubTreeWithoutRecursion = preOrderSubTreeWithoutRecursion(tree, 43);
        System.out.println(preOrderSubTreeWithoutRecursion.stream().map(BTree::toString).collect(Collectors.joining(", ")));;
    }

    private static List<BTree> preOrderSubTreeWithoutRecursion(BTree<Integer> tree, int subTreeTootValue) {
        List<BTree> list = new ArrayList<BTree>();

        BTree<Integer> cursor = tree;

        while (cursor != null && cursor.getValue() != subTreeTootValue) {
            if (subTreeTootValue < cursor.getValue()) {
                cursor = cursor.left;
            } else {
                cursor = cursor.right;
            }
        }

        Deque<BTree> stack = new LinkedList<>();

        do {
            if (cursor != null && cursor.left != null) {
                stack.push(cursor);
                cursor = cursor.left;
            } else {
                if (cursor == null) {
                    cursor = stack.poll();
                }

                if (cursor == null) {
                    return list;
                }

                list.add(cursor);

                cursor = cursor.right;
            }
        } while (true);
        
    }

    private static BTree<Integer> buildTree() {

        BTree<Integer> D = new BTree<>(2);
        BTree<Integer> E = new BTree<>(5);

        BTree<Integer> H = new BTree<>(13);

        BTree<Integer> M = new BTree<>(31);
        BTree<Integer> N = new BTree<>(41);
        BTree<Integer> P = new BTree<>(53);
        BTree<Integer> O = new BTree<>(47, null, P);

        BTree<Integer> L = new BTree<>(29, null, M);

        BTree<Integer> K = new BTree<>(37, L, N);

        BTree<Integer> J = new BTree<>(23, null, K);

        BTree<Integer> I = new BTree<>(43, J, O);

        BTree<Integer> G = new BTree<>(17, H, null);

        BTree<Integer> F = new BTree<>(11, null, G);

        BTree<Integer> C = new BTree<>(3, D, E);
        BTree<Integer> B = new BTree<>(7, C, F);

        BTree<Integer> A = new BTree<>(19, B, I);
        return A;
    }

}
