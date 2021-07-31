/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package career;

import static career.LinkedList__ReverseList.listToLinkedList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author 17864
 */
public class LinkedList__ReverseList_Recursive {

    public static void main(String[] args) {
        List<Integer> listA = Arrays.asList(1, 2, 33, 140);

        Node linkedListA = listToLinkedList(listA);

        //reverseList(linkedListA);
//        System.out.println("done");
        
        Node reversedList = reverseList(linkedListA, null);
        
        System.out.println(reversedList.toList());
    }

    public static Node reverseList(Node current, Node prev) {
        if (current == null) {
            return prev;
        }

        Node next = current.next;
        current.next = prev;
 
        return reverseList(next, current);
    }
}
