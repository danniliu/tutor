package app.dp;

/**
 * KnapsackRecursive 
 * Reference: https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 * Additional Info: tag: dynamic programming; difficulty: medium 
 * ************************** Description:
   Given weights and values of n items, 
   put these items in a knapsack of capacity W to get the maximum total value in the knapsack. 
   In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights 
   associated with n items respectively. Also given an integer W which represents knapsack capacity, 
   find out the maximum value subset of val[] such that sum of the weights of this subset 
   is smaller than or equal to W.
 * ************************** Analysis:
 * 1) This is brute force approach, it computes the same sub-problems again and again.
 * 2) time complexity of this naive recursive solution is exponential (2^n).
 * 3) space complexity: O(1), no extra space is used.
 */

public class KnapsackRecursive {

    // Returns the maximum value that can be put in a knapsack of capacity W 
    static int knapsack(int[] val, int[] wt, int W, int n){

        // Base Case 
        if (W == 0 || n==0) 
            return 0;

        // If weight of the nth item is less than or equal to Knapsack capacity W, then
        // Return the maximum of two cases:  
        // (1) nth item included  
        // (2) not included 
        if(W >= wt[n-1]) {
            return Math.max(val[n-1] + knapsack(val, wt, W-wt[n-1], n-1),
                knapsack(val, wt, W, n-1)
            );
        } else  { // If weight of the nth item is less than or equal to Knapsack capacity W, then         
                  // this item cannot be included in the optimal solution 
            return knapsack(val, wt, W, n-1);
        }

    }

    public static void main(String[] args) throws Exception {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(knapsack(val, wt, W, n));
    }
}