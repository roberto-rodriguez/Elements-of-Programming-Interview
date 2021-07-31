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
public class LinkedList__ReverseSubList2 {

    public static void main(String[] args) {
        List<Integer> listA = Arrays.asList(1,2,3,4,5,6,7,8);

        Node linkedList = listToLinkedList(listA);

        System.out.println(reverse(linkedList, 2, 5).toList());
    }

    public static Node reverse(Node linkedList, int start, int end) {
        Node dummyHead = new Node(null, linkedList);

        Node prev = dummyHead;
        Node current = dummyHead.next;
        Node next = null;
        Node listBegin = null;
        Node subListEnd = null;
        Node subListBegin = null;
        Node listEnd = null;

        for (int i = 1; i < start; i++) {
            prev = current;
            current = current.next;
        }

        listBegin = prev;
        subListEnd = current;

        for (int i = start; i <= end; i++) {
            next = current.next;
            current.next = prev;

            prev = current;
            current = next;
        }

        subListBegin = prev;
        listEnd = current;
        
        listBegin.next = subListBegin;
        subListEnd.next = listEnd;
 
        return dummyHead.next;
    }

}
