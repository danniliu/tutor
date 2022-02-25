package app.dp;
import java.util.*;

/**
* Leetcode: 1143. Longest Common Subsequence
 * Reference: https://leetcode.com/problems/coin-change/
 * youtube: https://www.youtube.com/watch?v=1R0_7HqNaW0
 * Additional Info: tag: DP; difficulty: medium 
 * ************************** Description:
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

    Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

    You may assume that you have an infinite number of each kind of coin.   
    Example 1:

    Input: coins = [1,2,5], amount = 11
    Output: 3
    Explanation: 11 = 5 + 5 + 1
    Example 2:

    Input: coins = [2], amount = 3
    Output: -1
    Example 3:

    Input: coins = [1], amount = 0
    Output: 0
    
    Constraints:

    1 <= coins.length <= 12
    1 <= coins[i] <= 231 - 1
    0 <= amount <= 104
 * 
 */

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // this is bottom up approach
        // optimization 1: Arrays.sort(coins);
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        for (int i=0; i<=amount; i++) {
            
            for (int j=0; j<coins.length; j++) {
                
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);  //dp remember if you consider the new coin
                }
                /** if array is sorted, no need to keep going
                else {
                    break;
                }
                 */
                
            }
            
        }
        
        return dp[amount] > amount? -1 : dp[amount];
    }
}
