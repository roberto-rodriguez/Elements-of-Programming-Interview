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
public class LinkedList__MergeTwoList {

    public static void main(String[] args) {
        List<Integer> listA = Arrays.asList(1, 2, 33, 140);
        List<Integer> listB = Arrays.asList(3, 4, 35);

        XNode linkedListA = listToLinkedList(listA);
        XNode linkedListB = listToLinkedList(listB);

        XNode cursorA = linkedListA;
        XNode cursorB = linkedListB;

        XNode result = merge(cursorA, cursorB);

        System.out.println(result.toList());
    }
    
     private static XNode merge(XNode cursorA, XNode cursorB) {
        XNode dummyHead = new XNode(0, null);
          XNode cursor = dummyHead;
        
        while(cursorA != null && cursorB != null){ 
            if(cursorA.getN() < cursorB.getN()){
                cursor.next = cursorA;
                cursorA = cursorA.next;
            }else{
                cursor.next = cursorB;
                cursorB = cursorB.next;
            }
            
            cursor = cursor.next;
        }
        
         cursor.next = cursorA == null ? cursorB : cursorA;

        return dummyHead.next;
    }
 

    private static XNode listToLinkedList(List<Integer> list) {
        XNode linkedList = new XNode(list.get(list.size() - 1));
        for (int i = list.size() - 2; i >= 0; i--) {
            linkedList = new XNode(list.get(i), linkedList);
        }
        return linkedList;
    }

}

class XNode {

    int n;

    XNode next;

    public List<Integer> toList() {
        List<Integer> list = new ArrayList();
        list.add(n);

        if (next != null) {
            list.addAll(next.toList());
        }
        return list;
    }

    public XNode(int n) {
        this.n = n;
    }

    public XNode(int n, XNode next) {
        this.n = n;
        this.next = next;
    }

    public int getN() {
        return n;
    }

    public XNode getNext() {
        return next;
    }

}
