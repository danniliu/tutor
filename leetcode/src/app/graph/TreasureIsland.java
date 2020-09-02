package app.graph;

/**
 * a994: Amazon | OA 2019 | Treasure Island
 * Reference: https://leetcode.com/discuss/interview-question/347457
 * Similar Leetcode: 994. Rotting Oranges
 * Reference: https://leetcode.com/problems/rotting-oranges/
 * Additional Info: tag: BFS; difficulty: medium 
 * **************************
    You have a map that marks the location of a treasure island. Some of the map area has jagged rocks and dangerous reefs. Other areas are safe to sail in. There are other explorers trying to find the treasure. So you must figure out a shortest route to the treasure island.

    Assume the map area is a two dimensional grid, represented by a matrix of characters. You must start from the top-left corner of the map and can move one block up, down, left or right at a time. The treasure island is marked as X in a block of the matrix. X will not be at the top-left corner. Any block with dangerous rocks or reefs will be marked as D. You must not enter dangerous blocks. You cannot leave the map area. Other areas O are safe to sail in. The top-left corner is always safe. Output the minimum number of steps to get to the treasure.

    Example:
    Input:
    [['O', 'O', 'O', 'O'],
    ['D', 'O', 'D', 'O'],
    ['O', 'O', 'O', 'O'],
    ['X', 'D', 'D', 'O']]
    Output: 5
    Explanation: Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps.
* ************************** Analysis:
    1) Use this one for interview
    2) Time: O(R * C) or O(N), N is the size of the grid 
    3) Space: O(N)
    4) One of the optimization is to mem grid height and width
 */
import java.util.*;

public class TreasureIsland {

    static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int foundTreasure(char[][] grid) {
        //BFS queue init
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});  //starting from top left

        //start BFS search for X
        int step = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                int[] cur = q.poll();
                // try the 4 directions
                for(int[] d: dir){
                    int x = cur[0] + d[0];  //row
                    int y = cur[1] + d[1];  //col
                    if(x>=0 && x<grid.length && y>=0 && y<grid[0].length){  //within the map
                        if(grid[x][y] == 'X') {
                            return step;
                        } else if (grid[x][y] == 'O') {
                            q.add(new int[]{x, y});
                        }
                    }
                }  // 4 dir loop
            }
            step ++;
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        TreasureIsland ro = new TreasureIsland();
        char[][] grid = {
            {'O', 'O', 'O', 'O'},
            {'D', 'O', 'D', 'O'},
            {'O', 'O', 'O', 'O'},
            {'X', 'D', 'D', 'O'}
        };
        
        int steps = ro.foundTreasure(grid);

        System.out.println("steps: " + steps);
    }

}