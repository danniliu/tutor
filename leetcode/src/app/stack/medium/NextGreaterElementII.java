package app.stack.medium;

import java.util.*;

/**
 * Leetcode: 503. Next Greater Element II
 * Reference: https://leetcode.com/problems/next-greater-element-ii/
 * Additional Info: tag: stack; difficulty: medium
 * ************************** Description:
    Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

    The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
    Example 1:

    Input: nums = [1,2,1]
    Output: [2,-1,2]
    Explanation: The first 1's next greater number is 2; 
    The number 2 can't find next greater number. 
    The second 1's next greater number needs to search circularly, which is also 2.
    Example 2:

    Input: nums = [1,2,3,4,3]
    Output: [2,3,4,-1,4]
    
    Constraints:

    1 <= nums.length <= 104
    -109 <= nums[i] <= 109
    
 * ************************** Analysis:
 *  This is stack approach:
    The key of this approach is that when we are trying to find the next greater number for the ith number and num[i] >= num[i+1], what do we do next? In the brute force way, we will go on to check num[i+2], num[i+3]... and there is much redundant work here. The better way is to check the next greater number of num[i+1]. If the next greater number of num[i+1] is still not greater than num[i], go on to check its next greater number.

    This approach makes use of a stack. This stack stores the indices of the appropriate elements from numsnums array. The top of the stack refers to the index of the Next Greater Element found so far. We store the indices instead of the elements since there could be duplicates in the numsnums array.

    We go through two such passes over the complete numsnums array. This is done so as to complete a circular traversal over the numsnums array.
 */

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums){
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();  //stack has index due to same values are possible

        int n = nums.length;
        for (int i=2*n-1; i>=0; i--){
            int currIndex = i % n;
            while (!stack.empty() && nums[stack.peek()] <= nums[currIndex] ) {
                stack.pop();
            }
            /**
             * If no element remains on the top of the stack, it means no larger element than nums[i]nums[i] exists to its right. Along with this, we also push the index of the element just encountered(nums[i]nums[i]), i.e. ii over the top of the stack, so that nums[i]nums[i](or stack[topstack[top) now acts as the Next Greater Element for the elements lying to its left.
             * This is also why we traversal from the right
             */
            res[currIndex] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(currIndex);
        }

        return res;
    }
}
