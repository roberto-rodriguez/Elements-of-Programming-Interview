/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package career;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author 17864
 */
public class LinkedList__ReverseSubList {

    public static void main(String[] args) {
        List<Integer> listA = Arrays.asList(11, 7, 5,3, 2);

        Node linkedList = listToLinkedList(listA);

        System.out.println(reverse(linkedList, 2, 5).toList());
    }

    public static Node reverse(Node linkedList, int start, int end) {
        Node dummyHead = new Node(0);
        dummyHead.next = linkedList;

        Node subListHead = dummyHead;

        Node prev = null;

        for (int i = 1; i < start; i++) {
            subListHead = subListHead.next;
        }

        System.out.println("subListHead = " + subListHead.getN());

        Node cursor = subListHead.next;//7

        for (int i = start; i < end; i++) {
            Node temp = cursor.next;              //5
            cursor.next = temp.next;                 // 7 - 3
            temp.next = subListHead.next; //cursor;                   //5 - 7 - 3
            subListHead.next = temp;        // 11 - 5 - 7 - 3
//            temp = cursor.next;
//            cursor.next = temp.next;
//            cursor = cursor.next;
//            temp.next = cursor.next;
//            cursor.next = temp;
        }
        return dummyHead.next;
    }

    public static void reverseSubList(Node linkedList, int start, int end) {
        Node cursor = linkedList;
        Node prev = null;

        for (int i = 0; i < start - 1; i++) {
            prev = cursor;
            cursor = cursor.next;
        }

        for (int i = start; i < end; i++) {
            Node temp = cursor.next;
            cursor.next = prev;

            prev = cursor;
            cursor = temp;
//            temp = cursor.next;
//            cursor.next = temp.next;
//            cursor = cursor.next;
//            temp.next = cursor.next;
//            cursor.next = temp;
        }

    }

    private static Node listToLinkedList(List<Integer> list) {
        Node linkedList = new Node(list.get(list.size() - 1));
        for (int i = list.size() - 2; i >= 0; i--) {
            linkedList = new Node(list.get(i), linkedList);
        }
        return linkedList;
    }
}
