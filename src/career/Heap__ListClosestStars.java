/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package career;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author 17864
 */
public class Heap__ListClosestStars {

    public static void main(String[] args) {
        List<Star> list = new ArrayList<>();
        list.add(new Star(4, 1, 1));
        list.add(new Star(2, 1, 1));
        list.add(new Star(1, 1, 1));
        list.add(new Star(3, 1, 1));
        list.add(new Star(5, 1, 1));
        list.add(new Star(7, 1, 1));

        PriorityQueue priorityQueue = new PriorityQueue(3, Collections.reverseOrder());

        for (Star star : list) {
            priorityQueue.add(star);

            if (priorityQueue.size() > 3) {
                priorityQueue.remove();
            }
        }

        List result = new ArrayList(priorityQueue);

        Collections.sort(result);

        System.out.println(result);
    } 
}

class Star implements Comparable<Star> {

    private Integer x, y, z;

    public Star(Integer x, Integer y, Integer z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Star(Integer x) {
        this.x = x;
    }

    @Override
    public int compareTo(Star o) {
        return this.distance().compareTo(o.distance());
    }

    @Override
    public String toString() {
        return x + ""; //To change body of generated methods, choose Tools | Templates.
    }

    public Integer distance() {
        Double d = Math.sqrt(x * x + y * y + z * z);
        return d.intValue();
    }

    public Integer getX() {
        return x;
    }

}
