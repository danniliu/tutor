package app.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode: 207. Course Schedule
 * Reference: https://leetcode.com/problems/course-schedule/
 * Additional Info: tag: DFS; difficulty: medium 
 * **************************
    There are a total of n courses you have to take, labeled from 0 to n-1.

    Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

    Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

    Example 1:

    Input: 2, [[1,0]] 
    Output: true
    Explanation: There are a total of 2 courses to take. 
                To take course 1 you should have finished course 0. So it is possible.
    Example 2:

    Input: 2, [[1,0],[0,1]]
    Output: false
    Explanation: There are a total of 2 courses to take. 
                To take course 1 you should have finished course 0, and to take course 0 you should
                also have finished course 1. So it is impossible.
    Note:

    The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
    You may assume that there are no duplicate edges in the input prerequisites.
 * **************************analysis:
 * This is using DFS to detect cycle in a directed graph:
 * 1) Detail explanation refer to : https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
 *    There is a cycle in a graph only if there is a back edge present in the graph. 
 *    A back edge is an edge that is from a node to itself (self-loop) or one of its ancestors in the   tree produced by DFS.
 *    This approach use a recStack to detect back edge.
 * 
 * 2) Time Complexity: O(E + V)
 * 3) Space Complexity: O(E + V) for the agencency list
 */

public class CourseScheduleDFS {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //Init the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        
        //build the ajacency list base on the dependencies
        for(int i=0; i<prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        boolean[] visited = new boolean[numCourses];
        //Use recStack[] array to keep track of vertices in the recursion stack.
        boolean[] recStack = new boolean[numCourses]; 
        
        for(int i=0; i<numCourses; i++){
            if (isCyclic(adj, i, visited, recStack)) return false;
        }   
        
        return true;
        
    }
    
    public static boolean isCyclic(List<List<Integer>> adj, int v, boolean[] visited, boolean[] recStack){
        if(recStack[v]) return true;  // this checking needs to be the first!
        if(visited[v]) return false;  //is the node has visited, no need to revisit
        
        visited[v] = true;
        recStack[v] = true;
        
        List<Integer> children = adj.get(v);
        for (Integer c: children){
            if (isCyclic(adj, c, visited, recStack)) {
                return true;
            }
        }
        recStack[v] = false;  // remove the vertex from the recursion stack
        return false;
    } 
    public static void main(String[] args) throws Exception {
        //no cycle
        /*
        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {2, 1}
            }; */
        //has cycle
        int[][] prerequisites = {
            {1, 0},
            {2, 1},
            {0, 2}
        };

        boolean canfinish = CourseScheduleDFS.canFinish(3, prerequisites);
        System.out.println(canfinish);
    }
}