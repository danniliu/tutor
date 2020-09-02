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
 *  1) Use iterative bottom-up approach
 *  2) Time Complexity: O(N*W).
    where ‘N’ is the number of weight element and ‘W’ is capacity. As for every weight element we traverse through all weight capacities 1<=w<=W.
    3) Auxiliary Space: O(N*W).
    The use of 2-D array of size ‘N*W’.
 */

public class KnapsackDP {

    // Returns the maximum value that can be put in a knapsack of capacity W 
    static int knapsack(int[] val, int[] wt, int W){

        int n = val.length;
        //k[i][j] will denote maximum value of ‘j-weight’ considering all values from ‘1 to ith’ item
        int[][] k = new int[n+1][W+1];

        //Init the first row and col to 0
        for (int i=0; i<W+1; i++){
            k[0][i] = 0;
        }
        for (int j=0; j<n+1; j++){
            k[j][0] = 0;
        }

        // Build table K[][] in bottom up iteratively
        // wt[] and val[] starts from 0, 
        //k[i][j] denote maximum value of ‘j-weight’ considering all values from ‘1 to ith’ item
        //that is why there is this 1 difference in the index of k[i][j] -- val[i-1], wt[i-1]
        for (int i=1; i<n+1; i++){ 
            for(int j=1; j<W+1; j++) { 
                if(wt[i-1] <= j) { //if the weight of ith item is less then j-weight
                    //select the max of consider the ith item or not
                    k[i][j] = Math.max(val[i-1] + k[i-1][j-wt[i-1]], k[i-1][j]);
                } else {
                    k[i][j] = k[i-1][j];
                }
            }
        }
       
        return k[n][W];
    }

    public static void main(String[] args) throws Exception {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        System.out.println(knapsack(val, wt, W));
    }
}