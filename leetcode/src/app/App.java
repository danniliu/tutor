package app;

import java.util.*;

/**
 * So i was giving an interview and was asked to sort three arrays.
For eg : Array a = {1,6,4} , b = {1,3,5} and c = {2,6}
Now the question is to sort these array so that the output can be
a = {1,1,2} b= {3,4,5} and c = {6,6} 

https://www.baeldung.com/java-concatenate-arrays

 * ************************** Analysis:
 */



class App {

  public boolean canFinish(int numCourses, int[][] prerequisites) {
       
        // build the graph:       
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0 ; i < numCourses; i++) {
            graph.add(new ArrayList<>());            
        }
        
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];
        for (int i=0; i<numCourses; i++){
            if(!visited[i]){
                if( isCyclic(graph, i, visited, stack)) {
                    return false;
                }
            }
        }
            
        return true;
    
    }
    
    private boolean isCyclic( List<List<Integer>> graph, int i, boolean[] visited, boolean[] stack) {
       
        if (stack[i]) return true;
         if (visited[i]) return false;
        
        visited[i] = true;
        stack[i] = true;
        
        List<Integer> children = graph.get(i);
        for (Integer child : children){
            if(isCyclic(graph, child, visited, stack)) {
                return true;
            }
        }
        
        stack[i] = false;
        return false;
    }

    public static void main (String[] args) {
      App test = new App();
      int[][] prerequisites = {{0,1}, {1,0}};

      boolean res = test.canFinish(2, prerequisites);
      System.out.println(res);
    }

}