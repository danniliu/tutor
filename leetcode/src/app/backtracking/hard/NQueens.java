package app.backtracking.hard;
import java.util.*;
/**
 * Leetcode: 51. N-Queens
 * Additional Info: tag: backtracking; difficulty: hard 
 * ************************** Description:
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
Example:
Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 * ************************** Analysis:
 * This is using back tracking.
 * This is exact solution for Leetcode 51
 */

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        // DS for the result
        List<List<String>> res = new ArrayList<>();
        
        // build an empty board
        char[][] board = new char[n][n];
        for(int r=0; r<n; r++){
          for (int c=0; c<n; c++){
            board[r][c] = '.';
          }
        }
        
        backtrack(res, board, 0);
        
        return res;
        
      }
    
      private void backtrack(List<List<String>> res, char[][] board, int col){
        int n = board.length;
        
        // when goal met, add the board to the results
        if (col == n){
          addBoard(res, board);
          return;
        }
        
        // start with place the Q from the left col
        for(int r=0; r<n; r++){
          // checkif it is safe to place Q at board[r][col]
          if (isSafe(board, r, col)){
            // add the Q to the board
            board[r][col] = 'Q';
            // move to the next col with the updated board state
            backtrack(res, board, col+1);
            // remove the Q from the board since we have explore all the possibilities via backtrack call
            board[r][col] = '.';
          }
        }
        
      }
    
      private boolean isSafe(char[][] board, int row, int col){
        int r, c;
        int n = board.length;
        // only need to check the board left to the current col
        
        // check current row
        for (c=0; c<col; c++){
          if (board[row][c] == 'Q') return false;
        }
        
        //check upper left diagnal
        for (c=col, r=row; c>=0 && r>=0; c--, r--){
          if (board[r][c] == 'Q') return false;
        }
        
        //check lower left diagnal
        for (c=col, r=row; c>=0 && r<n; c--, r++){
          if (board[r][c] == 'Q') return false;
        }
        
        return true;
      }
    
      private void addBoard(List<List<String>> res, char[][] board){
        List<String> list = new ArrayList<>();
        for (char[] row: board){
          list.add(new String(row));
        }
        
        res.add(list);
      }
}
