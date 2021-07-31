/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package career;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author 17864
 */
public class Heap__SortIncreasingDecreasingArray {

    public static void main(String[] args) {
//        int[] array = {57, 131, 493, 294, 221, 339, 418, 452, 442, 190};
        int[] array = {57, 131, 493, 294};

        System.out.println(sort(array));
 
    }

    public static List<Integer> sort(int[] array) {
        boolean increasing = true;

        int start = 0;

        PriorityQueue<Segment> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < array.length; i++) {
            int currentValue = array[i];
            Integer nextValue = null;

            if (i < array.length - 1) {
                nextValue = array[i + 1];
            }

            if (nextValue == null
                    || (increasing && currentValue > nextValue)
                    || (increasing == false && currentValue < nextValue)) {
                addSegment(priorityQueue, array, start, i, increasing);

                if (nextValue != null) {
                    start = i + 1;
                    increasing = !increasing;
                }
            }
        }

        Segment segment = null;

        List<Integer> result = new ArrayList<>();

        while ((segment = priorityQueue.poll()) != null) {
            result.add(segment.getCurrentValue());

            if (segment.setNextValue(array)) {
                priorityQueue.add(segment);
            }
        }

        return result;
    }

    private static void addSegment(PriorityQueue priorityQueue, int[] array, int start, int end, boolean increasing) {
        System.out.println("addSegment(PriorityQueue priorityQueue, int[] array, int start = " + start + ", int end = " + end + ", boolean increasing = " + increasing + ")");
        int currentIndex = increasing ? start : end;
        int currentValue = increasing ? array[start] : array[end];
        System.out.println("currentIndex = " + currentIndex + ", currentValue = " + currentValue);
        priorityQueue.add(new Segment(start, end, currentIndex, currentValue, increasing));
    }
}

class Segment implements Comparable<Segment> { 
    int start;
    int end;
    int currentIndex;
    Integer currentValue;
    boolean increasing; // 1 or -1

    public Segment(int start, int end, int currentIndex, Integer currentValue, boolean increasing) {
        this.start = start;
        this.end = end;
        this.currentIndex = currentIndex;
        this.currentValue = currentValue;
        this.increasing = increasing;
    }

    @Override
    public int compareTo(Segment other) {
        return currentValue.compareTo(other.getCurrentValue());
    }

    public Integer getCurrentValue() {
        return currentValue;
    }

    public boolean setNextValue(int[] array) {
        if (increasing) {
            if (++currentIndex <= end) {
                this.currentValue = array[currentIndex];
            } else {
                return false;
            }
        } else {
            if (--currentIndex >= start) {
                this.currentValue = array[currentIndex];
            } else {
                return false;
            }
        }
        return true;
    }

}
