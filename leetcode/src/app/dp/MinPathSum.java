package app.dp;

/**
 * Leetcode: 64. Minimum Path Sum
 * Reference: https://leetcode.com/problems/minimum-path-sum/
 * Additional Info: tag: arrasy, DP; difficulty: medium 
 * ************************** Description:
    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

    Note: You can only move either down or right at any point in time.

    Example:

    Input:
    [
    [1,3,1],
    [1,5,1],
    [4,2,1]
    ]
    Output: 7
    Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 * ************************** Analysis:
 * 1. optimization 1:
 *      int m = grid.length;
        int n = grid[0].length;
    2. Time complexity: O(m*n): traverse the entire matrix once
    3. Space Complexity: O(1): no extra space
 */

public class MinPathSum {
    //The value of grid[i][j] is reset to record the min cost of arriving grid[i][j]
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) 
            return 0;
        
        for(int r=1; r<grid.length; r++){ //set values for first col
            grid[r][0] = grid[r][0] + grid[r-1][0];
        }
        
        for(int c=1; c<grid[0].length; c++) {   //set values for first row
            grid[0][c] = grid[0][c] + grid[0][c-1];
        }
        
        for (int r=1; r<grid.length; r++) {
            for (int c=1; c<grid[0].length; c++) {
                grid[r][c] = Math.min(grid[r-1][c], grid[r][c-1])+ grid[r][c];
            }
        }
         
        return grid[grid.length-1][grid[0].length-1];                                   
    }

    public static void main(String[] args) throws Exception {
        int[][] input = {
            {1,3,1},
            {1,5,1},
            {4,2,1}
        };

        int sum = minPathSum(input);

        System.out.println(sum);
    }
}