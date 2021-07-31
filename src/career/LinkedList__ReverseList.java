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
public class LinkedList__ReverseList {

    public static void main(String[] args) {
        List<Integer> listA = Arrays.asList(1, 2, 33, 140);
        List<Integer> listB = Arrays.asList(3, 4, 35);

        Node linkedListA = listToLinkedList(listA);
        Node linkedListB = listToLinkedList(listB);

        Node result = reverse(linkedListB);

        System.out.println(result.toList());
    }

    private static Node reverse(Node list) {
        Node cursor = list;
        Node prev = null;

        while (cursor != null) {
            Node temp = cursor.next;
            cursor.next = prev;
            prev = cursor;
            cursor = temp;
        }

        return prev;
    }

    public static Node listToLinkedList(List<Integer> list) {
        Node linkedList = new Node(list.get(list.size() - 1));
        for (int i = list.size() - 2; i >= 0; i--) {
            linkedList = new Node(list.get(i), linkedList);
        }
        return linkedList;
    }

}

class Node {

    Integer n;

    Node next;

    public List<Integer> toList() {
        List<Integer> list = new ArrayList();
        list.add(n);
        
        Node cursor = next;
        
        while (cursor != null) {            
            list.add(cursor.getN());
            cursor = cursor.next;
        }

//        if (next != null) {
//            list.addAll(next.toList());
//        }
         return list;
    }

    public Node(Integer n) {
        this.n = n;
    }

    public Node(Integer n, Node next) {
        this.n = n;
        this.next = next;
    }

    public int getN() {
        return n;
    }

    public Node getNext() {
        return next;
    }

}
