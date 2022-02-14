package app.graph;

/**
 * Leetcode: 994. Rotting Oranges
 * Reference: https://leetcode.com/problems/rotting-oranges/
 * Additional Info: tag: BFS; difficulty: medium 
 * **************************
    In a given grid, each cell can have one of three values:
        the value 0 representing an empty cell;
        the value 1 representing a fresh orange;
        the value 2 representing a rotten orange.
    Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

    Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

    Example 1:

    Input: [[2,1,1],[1,1,0],[0,1,1]]
    Output: 4

    Example 2:

    Input: [[2,1,1],[0,1,1],[1,0,1]]
    Output: -1
    Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
    
    Example 3:

    Input: [[0,2]]
    Output: 0
    Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
* ************************** Analysis:
    1) Use this one for interview
    2) Time: O(R * C) or O(N), N is the size of the grid 
    3) Space: O(N)
    4) One of the optimization is to mem grid height and width
 */
import java.util.*;

public class RottingOrangesII {

    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int orangesRotting(int[][] grid) {
        //exceptional cases, ask for clarifications on returning 0 or -1
        if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        //get the count of fresh oranges and put the rotten oranges in a queue (as starting point of BFS)
        for(int i = 0; i < grid.length; i++) { //time: O(R * C) or O(N), N is the size of the grid 
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    fresh++;
                }
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        if(fresh == 0) return 0; // if there are no fresh oranges
        if(q.size() == 0) return -1;  // if there are no rotten oranges, but has fresh oranges
        int min = -1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] cur = q.remove();
                for(int[] d : dir) {
                    int x = cur[0] + d[0]; //row
                    int y = cur[1] + d[1]; //col
                    if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        q.add(new int[]{x, y});
                        fresh--;
                    }
                }
            }
            min++;
        }
        if(fresh != 0) {
            return -1;
        }
        return min;
    }

    public static void main(String[] args) throws Exception {
        RottingOrangesII ro = new RottingOrangesII();
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        int minutes = ro.orangesRotting(grid);

        System.out.println("Minutes: " + minutes);
    }

}