/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package career;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author 17864
 */
public class Heap__MergeOrderedList {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(3, 5, 7);
        List<Integer> list2 = Arrays.asList(0, 6);
        List<Integer> list3 = Arrays.asList(0, 6, 28);

        System.out.println(merge(Arrays.asList(list1, list2, list3)));
    }

    private static List<Integer> merge(List<List<Integer>> lists) {
        List<Integer> heads = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        PriorityQueue<Elem> priorityQueue = new PriorityQueue(new Comparator<Elem>() {
            @Override
            public int compare(Elem i1, Elem i2) {
                return i1.getN().compareTo(i2.getN());
            }
        });

        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);

            if (list.isEmpty()) {
                heads.add(0);
            } else {
                priorityQueue.add(new Elem(list.get(0), i));
                heads.add(1);
            }
        }

        Elem current = null;

        while ((current = priorityQueue.poll()) != null) {
            result.add(current.getN());

            int listIndex = current.getListIndex();
            int headIndex = heads.get(listIndex);

            if (headIndex < lists.get(listIndex).size()) {
                priorityQueue.add(new Elem(lists.get(listIndex).get(headIndex), listIndex));
            }

            heads.set(listIndex, heads.get(listIndex) + 1);
        }

        return result;
    }

}

class Elem { 
    private int listIndex;
    private Integer n;

    public Elem(Integer n, int listIndex) {
        this.listIndex = listIndex;
        this.n = n;
    }

    public Integer getN() {
        return n;
    }

    public int getListIndex() {
        return listIndex;
    }

}
