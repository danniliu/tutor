package app.graph;

/**
 * Leetcode: 261. Graph Valid Tree
 * Reference: https://leetcode.com/problems/graph-valid-tree/
 * Additional Info: tag: UF/DFS/BFS; difficulty: medium 
 * **************************
    Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

    Example 1:

    Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
    Output: true
    Example 2:
    Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
    Output: false
    Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0,1] is the same as [1,0] and thus will not appear together in edges.
    **************************analysis:
    This is to detect cycle of undirected graph, use union find, faster than DFS and BFS:
    Time complexity: O(n*n) in worst case and almost O(1) due to path compression
    Space complexity: O(N)

    About Tree and graph: 
    --> For the graph to be a valid tree, it must have exactly n - 1 edges. Any less, and it can't possibly be fully connected. Any more, and it has to contain cycles. Additionally, if the graph is fully connected and contains exactly n - 1 edges, it can't possibly contain a cycle, and therefore must be a tree!  (how to prove it?)
	--> (GG) An undirected graph is tree if it has following properties.
		1) There is no cycle.
		2) The graph is connected.
	--> A tree is a connected acyclic undirected graph.
    --> A forest is a disconnected acyclic graph.
 */

public class GraphValidTreeUF {
    int[] parent; // the set that a component belongs to
    int[] rank; //union by rank
    
    public GraphValidTreeUF(int n){  //init parent and rank
        parent  = new int[n];
        rank = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int i) { // find the parent: time complexity O(n*n) or almost O(1) due to path compression
        if (parent[i] != i) {
            parent[i] = find(parent[i]);  //path compression
        }
        
        return parent[i];
    }
    
    public boolean union(int x, int y) {  //union by rank, return true if there is union
        int parentX = find(x);
        int parentY = find(y);
        
        if (parentX == parentY) return false; //no need to union
        
        // We want to ensure the larger set remains the root.
        if(rank[parentX] < rank[parentY]) { 
            parent[parentX] = parentY;
            // The size of the larger set is the sum of the 2.
            rank[parentY] = rank[parentY] + rank[parentX];
        } else { //rank[x] is higher or equal to rank[y]
            parent[parentY] = parentX;
            rank[parentX] = rank[parentX] + rank[parentY];
        }
        
        return true;
    }
    public static void main(String[] args) throws Exception {
        boolean result = true;
        int n = 5; 
        int[][] edges = {{0,1}, {1,2}, {2,3}, {1,3}, {1,4}};
        // Condition 1 (or as one of the optimizations): The graph must contain n - 1 edges to be qualify as a tree
        if(edges.length != (n-1)) {result = false;}
        else {
            // Condition 2: The graph must contain a single connected component.
            // Create a new UnionFind object with n nodes. 
            GraphValidTreeUF uf = new GraphValidTreeUF(n);
            
            // Add each edge. Check if a merge happened, because if it 
            // didn't, there must be a cycle.
            for(int[] edge: edges){
                
                if(!uf.union(edge[0], edge[1])) {
                    result = false;
                    break;
                }
            }
            
        }
        System.out.println("valid tree? " + result);
    }
}