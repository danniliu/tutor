package app.graph;

/**
 * Leetcode: 207. Course Schedule
 * Reference: https://leetcode.com/problems/course-schedule/
 * https://www.youtube.com/watch?v=qe_pQCh09yU
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
 * This is using topological sort:
 * Actually, the problem is also known as topological sort problem, which is to find a global order for all nodes in a DAG (Directed Acyclic Graph) with regarding to their dependencies.

    A linear algorithm was first proposed by Arthur Kahn in 1962, in his paper of "Topological order of large networks". The algorithm returns a topological order if there is any. Here we quote the pseudo code of the Kahn's algorithm from wikipedia as follows:

    L = Empty list that will contain the sorted elements
    S = Set of all nodes with no incoming edge

    while S is non-empty do
        remove a node n from S
        add n to tail of L
        for each node m with an edge e from n to m do
            remove edge e from the graph
            if m has no other incoming edges then
                insert m into S

    if graph has edges then
        return error   (graph has at least one cycle)
    else 
        return L   (a topologically sorted order)
    To better understand the above algorithm, we summarize a few points here:

    In order to find a global order, we can start from those nodes which do not have any prerequisites (i.e. indegree of node is zero), we then incrementally add new nodes to the global order, following the dependencies (edges).
    Once we follow an edge, we then remove it from the graph.
    With the removal of edges, there would more nodes appearing without any prerequisite dependency, in addition to the initial list in the first step.
    The algorithm would terminate when we can no longer remove edges from the graph. There are two possible outcomes:
    1). If there are still some edges left in the graph, then these edges must have formed certain cycles, which is similar to the deadlock situation. It is due to these cyclic dependencies that we cannot remove them during the above processes.
    2). Otherwise, i.e. we have removed all the edges from the graph, and we got ourselves a topological order of the graph.
 */
import java.util.*;
  
class CourseScheduleTopoSort {
    class GNode {
        public Integer inDegrees = 0;
        public List<Integer> outNodes = new LinkedList<Integer>();
    }
  
    public boolean canFinish(int numCourses, int[][] prerequisites) {
  
      if (prerequisites.length == 0)
        return true; // no cycle could be formed in empty graph.
  
      // course -> list of next courses
      HashMap<Integer, GNode> graph = new HashMap<>();
  
      // build the graph first
      for (int[] relation : prerequisites) {
        // relation[1] -> relation[0]
        GNode prevCourse = this.getCreateGNode(graph, relation[1]);
        GNode nextCourse = this.getCreateGNode(graph, relation[0]);
  
        prevCourse.outNodes.add(relation[0]);
        nextCourse.inDegrees += 1;
      }
  
      // We start from courses that have no prerequisites.
      int totalDeps = prerequisites.length;
      LinkedList<Integer> nodepCourses = new LinkedList<Integer>();
      for (Map.Entry<Integer, GNode> entry : graph.entrySet()) {
        GNode node = entry.getValue();
        if (node.inDegrees == 0)
          nodepCourses.add(entry.getKey());
      }
  
      int removedEdges = 0;
      while (nodepCourses.size() > 0) {
        Integer course = nodepCourses.pop();
  
        for (Integer nextCourse : graph.get(course).outNodes) {
          GNode childNode = graph.get(nextCourse);
          childNode.inDegrees -= 1;
          removedEdges += 1;
          if (childNode.inDegrees == 0)
            nodepCourses.add(nextCourse);
        }
      }
  
      if (removedEdges != totalDeps)
        // if there are still some edges left, then there exist some cycles
        // Due to the dead-lock (dependencies), we cannot remove the cyclic edges
        return false;
      else
        return true;
    }
  
    /**
     * Retrieve the existing <key, value> from graph, otherwise create a new one.
     */
    protected GNode getCreateGNode(HashMap<Integer, GNode> graph, Integer course) {
      GNode node = null;
      if (graph.containsKey(course)) {
        node = graph.get(course);
      } else {
        node = new GNode();
        graph.put(course, node);
      }
      return node;
    }

    public static void main(String[] args) throws Exception {
        int[][] prerequisites = {
                {1, 0},
                {0, 2}
            };
        
        CourseScheduleTopoSort tSort = new CourseScheduleTopoSort();
        boolean canfinish = tSort.canFinish(3, prerequisites);
        System.out.println(canfinish);
    }
}