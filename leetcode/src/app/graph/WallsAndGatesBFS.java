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
    * ************************** Analysis: use BFS
    1) Time: O(R*C)
    2) SPace: O(R*C)
 */
import java.util.*;

public class WallsAndGatesBFS {
    private static final int EMPTY_ROOM = 100;
    private static final int GATE = 0;
    private static final int[][] DIRS = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };
    
    public void wallsAndGates(int[][] rooms) {
        //take care of exceptional cases
        if(rooms == null || rooms.length == 0) return;
        
        int rn = rooms.length, cn = rooms[0].length;
                                          
        //build a queue of gates
        LinkedList<int[]> queue = new LinkedList<>(); //space: worst case O(rn * cn)
        for(int r=0; r<rn; r++) { //time: worst case O(rn * cn)
            for(int c=0; c<cn; c++){
                if(rooms[r][c] == GATE){
                    queue.offer(new int[]{r, c});
                }
            }
        }
               
        //traverse the grid to fill each empty room with the distance to its nearest gate
        int[] point;
        while(!queue.isEmpty()) { //time: O(rn *cn)
            point = queue.poll();
            int startRow = point[0];
            int startCol = point[1];
            //loop through each direction of the point
            for(int[] dir: DIRS){
                int row = startRow + dir[0];
                int col = startCol + dir[1];
                //skip if moving beyond the grid or the room has been visited before.
                //the first visit from the gate for of the room is the distance to its nearest gate
                if(row<0 || row>=rn || col<0 || col>=cn || rooms[row][col] != EMPTY_ROOM) {
                    continue;
                } 
                rooms[row][col] = rooms[startRow][startCol] + 1;
                queue.offer(new int[]{row, col});
            }
        }                              
        
    }
    
    
    

    public static void main(String[] args) throws Exception {
        int[][] rooms = {
            {100,  -1,   0, 100},
            {100, 100, 100,  -1},
            {100,  -1, 100,  -1},
            {  0,  -1, 100,  100},
        };

        WallsAndGatesBFS wg = new WallsAndGatesBFS();
        wg.wallsAndGates(rooms);

        for(int[] row: rooms){
            for(int x: row){
                System.out.print(x + " ");
            }
            System.out.println("");
        }

    }
}