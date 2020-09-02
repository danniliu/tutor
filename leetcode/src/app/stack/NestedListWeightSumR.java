package app.stack;

/**
 * Leetcode: 339. Nested List Weight Sum
 * Reference: https://leetcode.com/problems/nested-list-weight-sum/
 * Additional Info: tag: stack/DFS; difficulty: easy
 * ************************** Description:
    Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

    Each element is either an integer, or a list -- whose elements may also be integers or other lists.

    Example 1:

    Input: [[1,1],2,[1,1]]
    Output: 10 
    Explanation: Four 1's at depth 2, one 2 at depth 1.
    Example 2:

    Input: [1,[4,[6]]]
    Output: 27 
    Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.
    
 * ************************** Analysis:
    * This is recursive approach, DFS:
    * Complexity Analysis
        The algorithm takes O(N)O(N) time, where NN is the total number of nested elements in the input list. For example, the list [ [[[[1]]]], 2 ] contains 44 nested lists and 22 nested integers (11 and 22), so N=6N=6.

        In terms of space, at most O(D)O(D) recursive calls are placed on the stack, where DD is the maximum level of nesting in the input. For example, D=2D=2 for the input [[1,1],2,[1,1]], and D=3D=3 for the input [1,[4,[6]]].
 */

import java.util.*;

public class NestedListWeightSumR {
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSumUtil(nestedList, 1);
    }
    
    public int depthSumUtil(List<NestedInteger> nestedList, int depth){
        int sum = 0;
        
        for(NestedInteger ni: nestedList){
            if(ni.isInteger()){
                sum = sum + ni.getInteger() * depth;
            } else {
                sum = sum + depthSumUtil(ni.getList(), depth+1);
            }
        }
        
        return sum;
    }
}