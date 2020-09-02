package app.graph;

/**
 * Leetcode: 200. Number of Islands
 * Reference: https://leetcode.com/problems/number-of-islands/
 * youtube tutorial by Kevin Naughton: https://www.youtube.com/watch?v=o8S2bO3pmO4&t=23s
 * Additional Info: tag: union find/DFS; difficulty: medium 
 * ************************** Description:
    Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

    Example 1:

    Input:
    11110
    11010
    11000
    00000

    Output: 1
    Example 2:

    Input:
    11000
    11000
    00100
    00011

    Output: 3
 * ************************** Analysis:
 * ---- run time: 1ms
 * ---- optimization 1
 * ---- Time Complexity: O(row x col):
    We know BFS and DFS have a runtime of O(|V| + |E|) (or O(V+E) for short).

    That means we just need to plug in.
    We're basically mapping every cell in the matrix to a node in a graph so the number of nodes is the same as the number of cells in the matrix. We are modeling every pair of adjacent cells as having an edge between them.

    With those definitions,
    V = the number of nodes/vertices = the number of cells in the matrix = M*N
    E = the number of edges = the number of adjacent pairs of cells = (as overestimated in prev comment), O(4MN)

    With those solved, we can just plug back into the original equation.

    Our runtime,
    T(n) = O( V + E )
    = O( # cells + # adjacent cell pairs )
    = O( MN + 4MN )
    = O(5MN)

    You're right that I was off - the overall runtime is O(5MN), but asymptotically that's still just O(MN).
 * 
 * ---- Space Complexity: worst case O(row x col), in case that the grid map is filled with lands wher DFS goes by row X col deep.
 */

public class NumberOfIslandDFS {
    public void dfs(char[][] grid, int r, int c){
        //check base cases
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';  //sunk the island
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c+1);
        dfs(grid, r, c-1);
    }
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        
        int numIslands = 0;
        int rn = grid.length, cn = grid[0].length; //optimization 1, reduce runtime from 2ms to 1ms, and faster than 99.96% of java online submision
        for (int r=0; r<rn; r++){
            for(int c=0; c<cn; c++){
                if(grid[r][c] == '1'){
                    numIslands++; 
                    dfs(grid, r, c);  //sunk the island and the neighboring islands
                }
            }
        }
            
        return numIslands;
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }
}