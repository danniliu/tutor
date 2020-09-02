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
import java.util.*;

public class NumberOfIslandBFS {
    
    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        
        int numIslands = 0;
        int rn = grid.length, cn = grid[0].length;
        int offset = Math.max(rn, cn);
        
        for (int r=0; r<rn; r++){
            for(int c=0; c<cn; c++){
                if(grid[r][c] == '1'){
                    numIslands++; 
                    //sunk the island
                    grid[r][c] = '0'; 
                    //sunk the neighboring island using BFS
                    LinkedList<Integer> q = new LinkedList<>(); //Queue for BFS
                    q.add(r*offset + c);
                    while(!q.isEmpty()){
                        int pair = q.poll();
                        int row = pair/offset, col = pair%offset;
                        if(row-1>=0 && grid[row-1][col]=='1'){
                            grid[row-1][col]='0';
                            q.add((row-1)*offset + col);
                        }
                        if(row+1<rn && grid[row+1][col]=='1'){
                            grid[row+1][col]='0';
                            q.add(offset*(row+1) + col);
                        }
                        if(col-1>=0 && grid[row][col-1]=='1'){
                            grid[row][col-1]='0';
                            q.add(offset*row + col-1);
                        }
                        if(col+1<cn && grid[row][col+1]=='1'){
                            grid[row][col+1]='0';
                            q.add(offset*row + col+1);
                        }
                    }
                }
            }
        }
            
        return numIslands;
    }

    public static void main(String[] args) throws Exception {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };

        int numIslands = numIslands(grid);
        System.out.println("numIslands = " + numIslands);
    }
}