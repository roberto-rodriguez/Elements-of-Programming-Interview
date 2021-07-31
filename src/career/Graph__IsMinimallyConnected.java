/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package career;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 17864
 */
public class Graph__IsMinimallyConnected {

    public static void main(String[] args) {
        GraphVertex a = new GraphVertex("A");
        GraphVertex b = new GraphVertex("B");
        GraphVertex c = new GraphVertex("C");
        GraphVertex d = new GraphVertex("D");
        GraphVertex e = new GraphVertex("E");
        GraphVertex f = new GraphVertex("F");
        GraphVertex g = new GraphVertex("G");
        GraphVertex h = new GraphVertex("H");
        GraphVertex i = new GraphVertex("I");
        GraphVertex j = new GraphVertex("J");
        GraphVertex k = new GraphVertex("K");
        GraphVertex l = new GraphVertex("L");
        GraphVertex m = new GraphVertex("M");

        a.add(b);
        b.add(e);
        c.add(d);
        d.add(e);
        e.add(f);
        e.add(h);
        f.add(g);
        f.add(i);
        i.add(j);
        i.add(m);
        m.add(k);
        k.add(l);

        System.out.println("Is minimally connected = " + (hasCycle(a, null) == false));
    }

    public static boolean hasCycle(GraphVertex vertex, GraphVertex origin) {

        if (vertex.visited) {
            return true;
        } else {
            vertex.visited = true;
        }

        for (GraphVertex edge : vertex.getEdges()) {
            if (origin != null && edge == origin) {
                continue;
            }

            if (hasCycle(edge, vertex)) {
                return true;
            }
        }
        return false;
    }
}

class GraphVertex {

    public String value;
    public boolean visited = false;
    public List<GraphVertex> edges = new ArrayList<>();

    public GraphVertex(String value) {
        this.value = value;
    }

    public void add(GraphVertex edge) {
        edges.add(edge);
        edge.edges.add(this);
    }

    public List<GraphVertex> getEdges() {
        return edges;
    }

    @Override
    public String toString() {
        return value; //To change body of generated methods, choose Tools | Templates.
    }

}
