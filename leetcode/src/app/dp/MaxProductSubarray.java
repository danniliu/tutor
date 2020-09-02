package app.dp;

/**
 * Leetcode: 152. Maximum Product Subarray
 * Reference: https://leetcode.com/problems/maximum-product-subarray/
 * Additional Info: tag: arrasy, DP; difficulty: medium 
 * ************************** Description:
    Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

    Example 1:

    Input: [2,3,-2,4]
    Output: 6
    Explanation: [2,3] has the largest product 6.
    Example 2:

    Input: [-2,0,-1]
    Output: 0
    Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * ************************** Analysis:
 * Because that we have the negative numbers and 0, the maximum product must come from the previous minim product or the maximum product times the current value, and then compare the current value to get the current minimum or maximum product.
 */

public class MaxProductSubarray {
    public static int maxProduct(int[] nums) {
        int len = nums.length;
        //special cases:
        if(len == 0) return 0;
        if(len == 1) return nums[0];
        
        int result = Integer.MIN_VALUE;
        int productMax = 1;
        int productMin = 1;
        for(int i=0; i<len; i++) {
            int currMin = Math.min(Math.min(nums[i]*productMin, nums[i]*productMax), nums[i]);
            int currMax = Math.max(Math.max(nums[i]*productMin, nums[i]*productMax), nums[i]);
            productMin = currMin;
            productMax = currMax;
            result = Math.max(result, productMax);
        }
        
        return result;
    }

    public static void main(String[] args) throws Exception {
        int[] input =  {1,3,1};

        int sum = MaxProductSubarray.maxProduct(input);

        System.out.println(sum);
    }
}