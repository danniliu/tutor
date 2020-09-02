package app.graph;

/**
 * a994: Amazon | OA 2019 | Treasure Island II
 * Reference: https://leetcode.com/discuss/interview-question/356150
 * Similar Leetcode: 994. Rotting Oranges
 * Reference: https://leetcode.com/problems/rotting-oranges/
 * Additional Info: tag: muti-source BFS; difficulty: medium 
 * **************************
    You have a map that marks the locations of treasure islands. Some of the map area has jagged rocks and dangerous reefs. Other areas are safe to sail in. There are other explorers trying to find the treasure. So you must figure out a shortest route to one of the treasure islands.

    Assume the map area is a two dimensional grid, represented by a matrix of characters. You must start from one of the starting point (marked as S) of the map and can move one block up, down, left or right at a time. The treasure island is marked as X. Any block with dangerous rocks or reefs will be marked as D. You must not enter dangerous blocks. You cannot leave the map area. Other areas O are safe to sail in. Output the minimum number of steps to get to any of the treasure islands.

    Example:

    Input:
    [['S', 'O', 'O', 'S', 'S'],
    ['D', 'O', 'D', 'O', 'D'],
    ['O', 'O', 'O', 'O', 'X'],
    ['X', 'D', 'D', 'O', 'O'],
    ['X', 'D', 'D', 'D', 'O']]

    Output: 3
    Explanation:
    You can start from (0,0), (0, 3) or (0, 4). The treasure locations are (2, 4) (3, 0) and (4, 0). Here the shortest route is (0, 3), (1, 3), (2, 3), (2, 4).

* ************************** Analysis:
    1) Use this one for interview
    2) Time: O(R * C) or O(N), N is the size of the grid 
    3) Space: O(N)
    4) One of the optimization is to mem grid height and width
 */
import java.util.*;

public class TreasureIslandMulti {

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