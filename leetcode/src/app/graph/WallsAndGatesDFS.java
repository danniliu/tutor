package app.graph;

/**
 * Leetcode: 286. Walls and Gates
 * Reference: https://leetcode.com/problems/walls-and-gates/
 * Additional Info: tag: DFS; difficulty: medium 
 * **************************
    You are given a m x n 2D grid initialized with these three possible values.

    -1 - A wall or an obstacle.
    0 - A gate.
    INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
    Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

    Example: 

    Given the 2D grid:

    INF  -1  0  INF
    INF INF INF  -1
    INF  -1 INF  -1
    0  -1 INF INF

    After running your function, the 2D grid should be:

    3  -1   0   1
    2   2   1  -1
    1  -1   2  -1
    0  -1   3   4
    * ************************** Analysis: use DFS
    1) Time: O(R*C)
    2) SPace: O(R*C)
 */

public class WallsAndGatesDFS {

    public static void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0) { 
            return;
        }
        
        for (int r=0; r<rooms.length; r++){
            
            for (int c=0; c<rooms[r].length; c++){
                if (rooms[r][c] == 0) {
                    dfs(rooms, r, c, 0);
                }
            }
        }
        
    }
    
    private static void dfs(int[][] rooms, int r, int c, int count){
        //base cases: make sure we are not going outside the grid, or a closer gate is already recorded
        if(r<0 || r>=rooms.length || c<0 || c>=rooms[0].length || rooms[r][c]<count) {
            return;
        }
        rooms[r][c] = count;
        dfs(rooms, r-1, c, count+1);
        dfs(rooms, r+1, c, count+1);
        dfs(rooms, r, c+1, count+1);
        dfs(rooms, r, c-1, count+1);
    }

    public static void main(String[] args) throws Exception {
        int[][] rooms = {
            {100,  -1,   0, 100},
            {100, 100, 100,  -1},
            {100,  -1, 100,  -1},
            {  0,  -1, 100,  100},
        };
        WallsAndGatesDFS.wallsAndGates(rooms);

        for(int[] row: rooms){
            for(int x: row){
                System.out.print(x + " ");
            }
            System.out.println("");
        }

    }
}