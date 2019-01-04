package graf_feladat;

import java.util.Iterator;
import java.util.LinkedList;

public class SzelessegiBejaras {

    private int V;
    private LinkedList<Integer> adj[];

    SzelessegiBejaras(Graf tempGraf, int kezdocsucs) {

        V = tempGraf.getCsucsok().size();
        adj = new LinkedList[V];
        for (int i = 0; i < V; ++i) {
            adj[i] = new LinkedList();
        }
        feltolt(tempGraf);

        System.out.println("A szélességi bejárása következik "
                + "(kiindulási csúcsa: " + kezdocsucs + "):");

        BFS(kezdocsucs);
        System.out.println("\n------------------\n");
    }

    private void feltolt(Graf tempGraf) {
        int Elekhossz = tempGraf.getElek().size();

        for (El el : tempGraf.getElek()) {
            if (el.getSuly() != 0) {
                addEdge(el.getCsucs1(), el.getCsucs2());
            }
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void BFS(int s) {

        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}
