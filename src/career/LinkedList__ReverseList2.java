/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package career;

import java.util.Arrays;
import java.util.List;
import static career.LinkedList__ReverseList.listToLinkedList;

/**
 *
 * @author 17864
 */
public class LinkedList__ReverseList2 {

    public static void main(String[] args) {
        // [1, 2, 3, 4]
        //p, <- c, n

        List<Integer> listA = Arrays.asList(1, 2, 33, 140);

        Node linkedListA = listToLinkedList(listA);

        //reverseList(linkedListA);
//        System.out.println("done");
        System.out.println(reverseList(linkedListA).toList());
    }

    public static Node reverseList(Node list) {
        Node prev = null;
        Node current = list;
        Node next = null;

        while (current != null) {
            next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next;
        }

        return prev;
    }
}
