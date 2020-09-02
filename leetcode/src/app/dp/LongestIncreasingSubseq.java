package app.dp;

/**
 * Leetcode: 300. Longest Increasing Subsequence
 * Reference: https://leetcode.com/problems/longest-increasing-subsequence/
 * Additional Info: tag: array, DP, binary search; difficulty: medium 
 * ************************** Description:
    Given an unsorted array of integers, find the length of longest increasing subsequence.
    Example:

    Input: [10,9,2,5,3,7,101,18]
    Output: 4 
    Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
    Note:

    There may be more than one LIS combination, it is only necessary for you to return the length.
    Your algorithm should run in O(n2) complexity.
    Follow up: Could you improve it to O(n log n) time complexity?
 * ************************** Analysis:
 *  1. DP approach.
    2. Time complexity: O(n^2): traverse the entire matrix once
    3. Space Complexity: O(n): extra len[n]
 */
import java.util.*;

public class LongestIncreasingSubseq{
    
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        //Array len[i] is used to memorize the size of the longest increasing subsequence
        int[] len = new int[nums.length];
        
        len[0] = 1;
        for(int i=1; i<nums.length; i++){
            len[i] = 1;
            for (int j=0; j<i; j++){
                
                if (nums[i] > nums[j]) {
                    len[i] = Math.max(len[i], (len[j] + 1));
                }
                
            }
        }
        Arrays.sort(len);
        return len[nums.length - 1];
    }

    public static void main(String[] args) throws Exception {
        int[] input = {10, 9, 2, 5, 3, 7, 101, 18};
        
        int sum = LongestIncreasingSubseq.lengthOfLIS(input);

        System.out.println(sum);
    }
}