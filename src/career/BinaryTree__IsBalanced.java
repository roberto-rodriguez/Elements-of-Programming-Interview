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
public class BinaryTree__IsBalanced {

    public static void main(String[] args) {
        BTree<String> tree = buildTree();

//        System.out.println(tree.preOrder());
//        System.out.println(tree.inOrder());
        System.out.println(tree.postOrder());
        System.out.println(tree.height());
        System.out.println("isBalanced() = " + (tree.isBalanced() != -1));
    }

    private static BTree<String> buildTree() {
        BTree<String> E = new BTree<>("E");
        BTree<String> X = new BTree<>("X");
        BTree<String> F = new BTree<>("F", null, X);
        BTree<String> D = new BTree<>("D", E, F);
        BTree<String> G = new BTree<>("G");
        BTree<String> C = new BTree<>("C", D, G);
        BTree<String> I = new BTree<>("I");
        BTree<String> J = new BTree<>("J");
        BTree<String> H = new BTree<>("H", I, J);
        BTree<String> B = new BTree<>("B", C, H);
        BTree<String> M = new BTree<>("M");
        BTree<String> N = new BTree<>("N");
        BTree<String> L = new BTree<>("L", M, N);
        BTree<String> O = new BTree<>("O");
        BTree<String> K = new BTree<>("K", L, O);
        BTree<String> A = new BTree<>("A", B, K);
        return A;
    }
}

class BTree<T> {

    private T value;
    public BTree<T> left;
    public BTree<T> right;

    public boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public String toString() {
        return value + ""; //To change body of generated methods, choose Tools | Templates.
    }

    public Integer height() {
        int height = 0;
        if (left == null && right == null) {
            return 0;
        }

        if (left == null) {
            height = right.height();
        } else {
            if (right == null) {
                height = left.height();
            } else {
                height = Math.max(left.height(), right.height());
            }
        }
        return height + 1;
    }

    public Integer isBalanced() {
        int leftHeight = 0;
        int rightHeight = 0;
        if (left == null && right == null) {
            return 0;
        }

        if (left == null) {
            leftHeight = 0;
        } else {
            leftHeight = left.height();
        }
        if (right == null) {
            rightHeight = 0;
        } else {
            rightHeight = right.height();
        }

        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, leftHeight);
        }
    }

    public List<T> preOrder() {
        List<T> list = new ArrayList<>();
        list.add(value);

        if (left != null) {
            list.addAll(left.preOrder());
        }
        if (right != null) {
            list.addAll(right.preOrder());
        }
        return list;
    }

    public List<T> inOrder() {
        List<T> list = new ArrayList<>();

        if (left != null) {
            list.addAll(left.inOrder());
        }

        list.add(value);

        if (right != null) {
            list.addAll(right.inOrder());
        }
        return list;
    }

    public List<T> postOrder() {
        List<T> list = new ArrayList<>();

        if (left != null) {
            list.addAll(left.inOrder());
        }

        if (right != null) {
            list.addAll(right.inOrder());
        }

        list.add(value);
        return list;
    }

    public BTree(T value) {
        this.value = value;
    }

    public BTree(T value, BTree<T> left, BTree<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public T getValue() {
        return value;
    }

}
