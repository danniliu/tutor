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
 * ---- run time: 13 ms, much slower than DFS ????
 * ---- Time Complexity: 
    O(M×N) where M is the number of rows and N is the number of columns.
 * ---- Space Complexity:
    O(min(M,N)) because in worst case where the grid is filled with lands, the size of queue can grow up to min(M,NM,N).
 */

public class NumberOfIslandUF {
    
    class UnionFind {
        int count; // # of connected components
        int[] parent;
        int[] rank;
    
        public UnionFind(char[][] grid) { // for problem 200
          count = 0;
          int m = grid.length;
          int n = grid[0].length;
          parent = new int[m * n];
          rank = new int[m * n];
          for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
              if (grid[i][j] == '1') {
                parent[i * n + j] = i * n + j;
                ++count;
              }
              rank[i * n + j] = 0;
            }
          }
        }
    
        public int find(int i) { // path compression
          if (parent[i] != i) parent[i] = find(parent[i]);
          return parent[i];
        }
    
        public void union(int x, int y) { // union with rank
          int rootx = find(x);
          int rooty = find(y);
          if (rootx != rooty) {
            if (rank[rootx] > rank[rooty]) {
              parent[rooty] = rootx;
            } else if (rank[rootx] < rank[rooty]) {
              parent[rootx] = rooty;
            } else {
              parent[rooty] = rootx; rank[rootx] += 1;
            }
            --count;
          }
        }
    
        public int getCount() {
          return count;
        }
      }
    
      public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
          return 0;
        }
    
        int nr = grid.length;
        int nc = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int r = 0; r < nr; ++r) {
          for (int c = 0; c < nc; ++c) {
            if (grid[r][c] == '1') {
              //grid[r][c] = '0'; this is not needed
              if (r - 1 >= 0 && grid[r-1][c] == '1') {
                uf.union(r * nc + c, (r-1) * nc + c);
              }
              if (r + 1 < nr && grid[r+1][c] == '1') {
                uf.union(r * nc + c, (r+1) * nc + c);
              }
              if (c - 1 >= 0 && grid[r][c-1] == '1') {
                uf.union(r * nc + c, r * nc + c - 1);
              }
              if (c + 1 < nc && grid[r][c+1] == '1') {
                uf.union(r * nc + c, r * nc + c + 1);
              }
            }
          }
        }
    
        return uf.getCount();
      }
    
    public static void main(String[] args) throws Exception {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '0', '1'},
        };

        NumberOfIslandUF solution =  new NumberOfIslandUF();

        int numIslands = solution.numIslands(grid);
        System.out.println("numIslands = " + numIslands);
    }
}