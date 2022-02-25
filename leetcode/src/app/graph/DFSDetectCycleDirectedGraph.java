 package app.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Reference: 
 * You tube Intro: https://www.youtube.com/watch?v=joqmqvHC_Bo Code:
 * https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
 * Use DFS to detect cycle in a directed graph
 */

 public class DFSDetectCycleDirectedGraph{
    private int V;
    private List<List<Integer>> adj;

    public DFSDetectCycleDirectedGraph(int v){
        this.V = v;
        adj = new ArrayList<>();

        for (int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
    }

    private void addEdge(int v, int l){
        adj.get(v).add(l);
        //adj.get(l).add(v); // for undirected graph
    }

    private boolean isCyclicDFS(int v, boolean[] visited, boolean[] recStack) {
        if(recStack[v]) return true;
        if(visited[v]) return false;

        visited[v] = true;
        recStack[v] = true; 
        List<Integer> children = adj.get(v);
        for(Integer c: children) {
            if (isCyclicDFS(c, visited, recStack)) return true;
        }
        
        recStack[v] = false; //remove the vetext from the recursion stack before checking the next vertex
        return false;
    }  

    private boolean isCyclic() {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V]; //Recursion stack

        for (int v=3; v>=0; v--){
            if(isCyclicDFS(v, visited, recStack)) {
                return true;
            }
        }

        return false;
    }

     public static void main(String[] args){
        DFSDetectCycleDirectedGraph graph = new DFSDetectCycleDirectedGraph(4);

        //graph.addEdge(3, 3); 
        graph.addEdge(2, 0); 
        graph.addEdge(2, 3); 
        graph.addEdge(1, 2); 
        graph.addEdge(0, 1); 
        graph.addEdge(0, 2); 

        if (graph.isCyclic()) {
            System.out.println("This graph is cyclic.");
        } else {
            System.out.println("This graph is NOT cyclic.");
        }
     }
 }