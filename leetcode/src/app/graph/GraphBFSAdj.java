package app.graph;

/**
 * BFS Geek for Geeks tutorial in you tube: https://www.youtube.com/watch?v=0u78hx-66Xk
 * BFS Geek for Geeks code: https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
 * This BFS is using adjacency list to represent graph.
 * 
 */

import java.util.*;

public class GraphBFSAdj {
    List<List<Integer>> adj;
    int V;

    public GraphBFSAdj(int v){
        V = v;
        adj = new ArrayList<>();

        for (int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int s, int d) {
        adj.get(s).add(d);
    }

    public void BFS(int start) {
        boolean[] visited = new boolean[V]; //default is false
        LinkedList<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()) {
            Integer p = queue.poll();
            System.out.print(p + "  ");

            List<Integer> children = adj.get(p);
            for(Integer c: children) {
                if (!visited[c] ) {
                    visited[c] = true;
                    queue.add(c);
                }
            }
        }

        

    }


    public static void main(String[] args) throws Exception {

        GraphBFSAdj g = new GraphBFSAdj(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        int n = 2;
        System.out.println("BFS traversal from node " + n);
        g.BFS(2);
    }
}