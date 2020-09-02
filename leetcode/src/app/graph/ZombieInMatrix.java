package app.graph;

/**
 * Leetcode: a994: Zombie in Matrix (Amazon)
 * Reference: https://leetcode.com/discuss/interview-question/411357/ 
 * Additional Info: tag: BFS; difficulty: medium 
 * **************************
    Given a 2D grid, each cell is either a zombie 1 or a human 0. Zombies can turn adjacent (up/down/left/right) human beings into zombies every hour. Find out how many hours does it take to infect all humans?

    Example:

    Input:
    [[0, 1, 1, 0, 1],
    [0, 1, 0, 1, 0],
    [0, 0, 0, 0, 1],
    [0, 1, 0, 0, 0]]

    Output: 2

    Explanation:
    At the end of the 1st hour, the status of the grid:
    [[1, 1, 1, 1, 1],
    [1, 1, 1, 1, 1],
    [0, 1, 0, 1, 1],
    [1, 1, 1, 0, 1]]

    At the end of the 2nd hour, the status of the grid:
    [[1, 1, 1, 1, 1],
    [1, 1, 1, 1, 1],
    [1, 1, 1, 1, 1],
    [1, 1, 1, 1, 1]]

* ************************** Analysis:
    1) Use this one for interview
    2) Time: O(R * C) or O(N), N is the size of the grid 
    3) Space: O(N)
 */
import java.util.*;

public class ZombieInMatrix {
    private static final int HUMAN = 0;
    private static final int ZOMBIE = 1;
    private static final int IMPOSSIBLE = -1;
    private static final int[][] DIRS = {
        {-1, 0}, {1, 0}, {0, 1}, {0, -1}
    };
    
    public int minHours(int rows, int cols, List<List<Integer>> grid) {
        
        //specail cases:
        if(rows == 0 || cols == 0 || grid == null || grid.isEmpty()) return 0;

        //build a queue with  zombies in the matrix, and countof Zombies
        LinkedList<int[]> queue = new LinkedList<>();  //space: worst case O(N), N --> rows * cols
        //Memorize count of humans
        int countH = rows*cols;
        for (int r=0; r<rows; r++){ //time: O(N), N --> rows * cols, every item in the grid is visited
            List<Integer> row = grid.get(r);
            for (int c=0; c<cols; c++) {
                int item = row.get(c);
                if(item == ZOMBIE){
                    queue.offer(new int[]{r, c});
                    countH --;
                }
            }
        }

        if (countH == 0) return 0;
        if (queue.size() == 0) return IMPOSSIBLE;
        //Use BFS to traverse the grid and change human to zombie
        int minhours = 0;
        while(!queue.isEmpty() && countH>0){ //time: worst case, O(4N), N --> rows * cols
            int size = queue.size();
            //handle the queue one level at a time
            for(int i = 0; i<size; i++){ 
                int[] point = queue.poll();
                int pointRow = point[0];
                int pointCol = point[1];  
                //traverse the 4 directions 
                for(int[] dir: DIRS) {  
                    int r = pointRow + dir[0];
                    int c = pointCol + dir[1];
                    if (r>=0 && r<rows && c>=0 && c<cols && grid.get(r).get(c) == HUMAN ){
                        grid.get(r).set(c, ZOMBIE);
                        queue.offer(new int[]{r, c});
                        countH --;
                    }
                    
                }
            }
            minhours ++;

        }
        if(countH != 0) return IMPOSSIBLE;
        return minhours--;  //get rid of an extra count
    }

    public static void main(String[] args) throws Exception {
        
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(0, 1, 1, 0, 1));
        grid.add(Arrays.asList(0, 1, 0, 1, 0));
        grid.add(Arrays.asList(0, 0, 0, 0, 1));
        grid.add(Arrays.asList(0, 1, 0, 0, 0));

        ZombieInMatrix zm = new ZombieInMatrix();

        int result = zm.minHours(4, 5, grid);

        /*
        List<List<Integer>> grid = new ArrayList<>() {
            {
                add(Arrays.asList(0, 1, 1, 0, 1));
                add(Arrays.asList(0, 1, 1, 0, 1));
                add(Arrays.asList(0, 1, 1, 0, 1));
                add(Arrays.asList(0, 1, 1, 0, 1));
            }
        };
        */
        
        

        System.out.println("Hours: " + result);
    }

}