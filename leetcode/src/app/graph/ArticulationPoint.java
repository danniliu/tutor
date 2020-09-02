package app.graph;

/**
 * Leetcode: Articulation Points (or Cut Vertices) in a Graph
 * Reference: https://www.geeksforgeeks.org/articulation-points-or-cut-vertices-in-a-graph/?ref=lbp
 * Additional Info: tag: DFS; difficulty: medium 
 * **************************
    A vertex in an undirected connected graph is an articulation point (or cut vertex) if removing it (and edges through it) disconnects the graph. 
    
    Articulation points represent vulnerabilities in a connected network – single points whose failure would split the network into 2 or more components. They are useful for designing reliable networks.
    
    For a disconnected undirected graph, an articulation point is a vertex removing which increases number of connected components.
 * **************************analysis:
    A O(V+E) algorithm to find all Articulation Points (APs) (Tarjan’s algorithm):
    The idea is to use DFS (Depth First Search). In DFS, we follow vertices in tree form called DFS tree. In DFS tree, a vertex u is parent of another vertex v, if v is discovered by u (obviously v is an adjacent of u in graph). In DFS tree, a vertex u is articulation point if one of the following two conditions is true.
    1) u is root of DFS tree and it has at least two children.
    2) u is not root of DFS tree and it has a child v such that no vertex in subtree rooted with v has a back edge to one of the ancestors (in DFS tree) of u.
 * 
 * undirected graph
 */

public class ArticulationPoint {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        return true;
        
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