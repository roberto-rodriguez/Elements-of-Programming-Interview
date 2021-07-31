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
public class Sorting__Render_a_Calendar {

    public static void main(String[] args) {
        List<Event> events = buildEvents();

        final List<EventLimit> eventLimits = new ArrayList<>();

        events.stream().map(Event::toEventLimit)
                .forEach(limits -> eventLimits.addAll(limits));

        Collections.sort(eventLimits);

        int sum = 0;
        int max = 0;

        for (EventLimit eventLimit : eventLimits) {
            sum += eventLimit.sign;
            max = Math.max(max, sum);
        }

        System.out.println("max = " + max);
    }

    public static List<Event> buildEvents() {
        List<Event> events = new ArrayList<>();

        events.add(new Event(1, 5));
        events.add(new Event(6, 10));
        events.add(new Event(11, 13));
        events.add(new Event(14, 15));
        events.add(new Event(2, 7));
        events.add(new Event(8, 9));
        events.add(new Event(12, 15));
        events.add(new Event(4, 5));
        events.add(new Event(9, 17));

        return events;
    }
}

class EventLimit implements Comparable {

    public Integer point, sign;

    @Override
    public String toString() {
        return point + "";
    }

    public EventLimit(Integer point, Integer sign) {
        this.point = point;
        this.sign = sign;
    }

    @Override
    public int compareTo(Object o) {
        return point.compareTo(((EventLimit) o).point);
    }

}

class Event {

    public Integer start, end;

    public Event(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public List<EventLimit> toEventLimit() {
        List<EventLimit> list = new ArrayList<>();
        list.add(new EventLimit(start, 1));
        list.add(new EventLimit(end, -1));
        return list;
    }
}
