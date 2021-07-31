/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package career;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author 17864
 */
public class Greedy__IntervalCovering {

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(0, 3));
        list.add(new Interval(2, 6));
        list.add(new Interval(3, 4));
        list.add(new Interval(6, 9));

        System.out.println(minimumNumberOfIntersections(list));
    }

    public static List<Integer> minimumNumberOfIntersections(List<Interval> list) {
        List<Integer> visits = new ArrayList<>();

        Collections.sort(list);

        int coveredIntervals = 0;

        while (coveredIntervals < list.size()) {
            Interval intersection = list.get(coveredIntervals++);

            while (coveredIntervals < list.size() && intersect(intersection, list.get(coveredIntervals))) {
                intersection = getIntersection(intersection, list.get(coveredIntervals++));
            }
            visits.add(intersection.start);
        }

        return visits;
    }

    private static boolean intersect(Interval a, Interval b) {
        return (a.start >= b.start && a.start <= b.end) || (a.end >= b.start && a.end <= b.end);
    }

    private static Interval getIntersection(Interval a, Interval b) {
        return new Interval(Math.max(a.start, b.start), Math.min(a.end, b.end));
    }
}

class Interval implements Comparable<Interval> {

    public Integer start, end;

    public Interval(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Interval o) {
        return start.compareTo(o.start);
    }
}
