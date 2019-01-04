package graf_feladat;

import java.util.Iterator;
import java.util.LinkedList;

public class MelysegiBejaras {

    private int V;
    private LinkedList<Integer> adj[];

    MelysegiBejaras(Graf tempGraf, int kezdocsucs) {
        V = tempGraf.getCsucsok().size();
        adj = new LinkedList[V];
        for (int i = 0; i < V; ++i) {
            adj[i] = new LinkedList();
        }
        feltolt(tempGraf);

        System.out.println("A mélységi bejárása következik "
                + "(kiindulási csúcsa: " + kezdocsucs + "):");

        DFS(kezdocsucs);
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

    private void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    void DFS(int v) {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }

}
