package app.graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Reference: 
 * 	--> Intro in youtube: https://youtu.be/Q9PIxaNGnig
 *  --> Code in GG: https://www.geeksforgeeks.org/topological-sorting/   
 *  --> Time Complexity: The above algorithm is simply DFS with an extra stack. So time complexity is the same  as DFS which is O(V+E). 
 */

public class GraphTopoSort{
    int V;
    List<List<Integer>> adj;

    public GraphTopoSort (int v){
        V = v;
        adj = new ArrayList<>();
        for (int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
    }

    private void addEdge(int start, int end){
        adj.get(start).add(end);
    }

    private void topoSortUtil(int v, boolean[] visited, Stack<Integer> stack){
        if (visited[v]) return;

        visited[v] = true; //stop
        List<Integer> children = adj.get(v);
        for(Integer c: children) {
            if(!visited[c]) 
                topoSortUtil(c, visited, stack);
        }

        stack.push(new Integer(v));
    }

    private void topoSort(){
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[V];

        for (int i=0; i<V; i++){
            if(!visited[i]) {
                topoSortUtil(i, visited, stack);
            }
        }

        while(!stack.empty()){
            System.out.print(stack.pop());
        }

    }

    public static void main(String[] args) {
        GraphTopoSort g = new GraphTopoSort(2);
        g.addEdge(1, 0); 
        g.addEdge(0, 1); 
        /* g.addEdge(5, 2);  
        g.addEdge(5, 0);  
        g.addEdge(4, 0);  
        g.addEdge(4, 1);  
        g.addEdge(2, 3);  
        g.addEdge(3, 1);  */

        System.out.println("Topological sort of the graph: ");
        g.topoSort();
    }
}