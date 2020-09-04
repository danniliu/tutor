package app.dp;

/**
 * Leetcode: 746. Min Cost Climbing Stairs
 * Reference: https://leetcode.com/problems/min-cost-climbing-stairs/
 * Additional Info: tag: dp, array; difficulty: easy 
 * ************************** Description:
    On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
    Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

    Example 1:
    Input: cost = [10, 15, 20]
    Output: 15
    Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
    Example 2:
    Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
    Output: 6
    Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
    Note:
    cost will have a length in the range [2, 1000].
    Every cost[i] will be an integer in the range [0, 999].
 * ************************** Analysis:
 * https://leetcode.com/discuss/general-discussion/458695/dynamic-programming-patterns/439810
 * DP pattern: Minimum (Maximum) Path to Reach a Target
    Generate problem statement for this pattern
    Statement
    Given a target find minimum (maximum) cost / path / sum to reach the target.
    Approach
    Choose minimum (maximum) path among all possible paths before the current state, then add value for the current state.
 * 
 */

public class MinCostClimbingStairsII {
    //This solution may have issues, some test cases don't pass
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length ==0 ) {
            return 0;
        }
        int f1 = cost[0], f2 = cost[1];
        int fCurrent;
        for(int i=2; i<cost.length; i++){
            fCurrent = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = fCurrent;
        }
        
        return Math.min(f1, f2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }
}