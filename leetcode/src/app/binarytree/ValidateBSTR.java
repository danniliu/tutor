package app.binarytree;

/**
 * Leetcode: Validate Binary Search Tree
 * Reference: https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2874/
 * Additional Info: tag: binary tree; difficulty: easy 
 * ************************** Description:
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 * ************************** Analysis:
 * This is recursion approach.
 * Complexity Analysis
    Time complexity : O(N) since we visit each node exactly once.
    Space complexity : O(N) since we keep up to the entire tree.
 */

public class ValidateBSTR {
    public boolean isValidBST(TreeNode root) {
        
        return isValidBSTUtil(root, null, null);
        
    }
    
    boolean isValidBSTUtil(TreeNode root, Integer min, Integer max){
        if(root == null) return true;
        
        int val = root.val;
        System.out.println(val);
        //make sure the value of the node meets BST condition
        if(min != null && val <= min) return false;
        if(max != null && val >= max) return false;
        
        //Make recursive calls with the left and right child, tighten the min and max
        return (isValidBSTUtil(root.left, min, val)
               && isValidBSTUtil(root.right, val, max));
        
    }
    
    public static void main(String[] args) throws Exception {
        ValidateBSTR bst = new ValidateBSTR();

        
    }
}