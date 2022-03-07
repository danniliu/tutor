package app.backtracking.hard;

/**
 * Leetcode: 51. N-Queens
 * Reference: Geekforgeeks: https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/
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
 * This is GeekForGeeks version, only return one board, not exact solution for Leetcode 51
 */

/* Java program to solve N Queen Problem using 
backtracking */
public class NQueensGGBT { 
	final int N = 4; 

	/* A utility function to print solution */
	void printSolution(int board[][]) 
	{ 
		for (int i = 0; i < N; i++) { 
			for (int j = 0; j < N; j++) 
				System.out.print(" " + board[i][j] 
								+ " "); 
			System.out.println(); 
		} 
	} 

	/* A utility function to check if a queen can 
	be placed on board[row][col]. Note that this 
	function is called when "col" queens are already 
	placeed in columns from 0 to col -1. So we need 
	to check only left side for attacking queens */
	boolean isSafe(int board[][], int row, int col) 
	{ 
		int i, j; 

		/* Check this row on left side */
		for (i = 0; i < col; i++) 
			if (board[row][i] == 1) 
				return false; 

		/* Check upper diagonal on left side */
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--) 
			if (board[i][j] == 1) 
				return false; 

		/* Check lower diagonal on left side */
		for (i = row, j = col; j >= 0 && i < N; i++, j--) 
			if (board[i][j] == 1) 
				return false; 

		return true; 
	} 

	/* A recursive utility function to solve N 
	Queen problem */
	boolean solveNQUtil(int board[][], int col) 
	{ 
		/* base case: If all queens are placed 
		then return true */
		if (col >= N) 
			return true; 

		/* Consider this column and try placing 
		this queen in all rows one by one */
		for (int i = 0; i < N; i++) { 
			/* Check if the queen can be placed on 
			board[i][col] */
			if (isSafe(board, i, col)) { 
				/* Place this queen in board[i][col] */
				board[i][col] = 1; 

				/* recur to place rest of the queens */
				if (solveNQUtil(board, col + 1) == true) 
					return true; 

				/* If placing queen in board[i][col] 
				doesn't lead to a solution then 
				remove queen from board[i][col] */
				board[i][col] = 0; // BACKTRACK 
			} 
		} 

		/* If the queen can not be placed in any row in 
		this colum col, then return false */
		return false; 
	} 

	boolean solveNQ() 
	{ 
		int board[][] = { { 0, 0, 0, 0 }, 
						{ 0, 0, 0, 0 }, 
						{ 0, 0, 0, 0 }, 
						{ 0, 0, 0, 0 } }; 

		if (solveNQUtil(board, 0) == false) { 
			System.out.print("Solution does not exist"); 
			return false; 
		} 

		printSolution(board); 
		return true; 
	} 

	// driver program to test above function 
	public static void main(String args[]) 
	{ 
		NQueensGGBT Queen = new NQueensGGBT(); 
		Queen.solveNQ(); 
	} 
} 