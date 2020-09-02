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
 * This is iterative approach.
 * Complexity Analysis
    Time complexity : O(N) since we visit each node exactly once.
    Space complexity : O(N) since we keep up to the entire tree.
 */
import java.util.*;

public class ValidateBSTI {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        
        //Initialize 3 stacks for DFS traversal
        LinkedList<TreeNode> nodeStack = new LinkedList<>();
        LinkedList<Integer> minStack = new LinkedList<>();
        LinkedList<Integer> maxStack = new LinkedList<>();
       
        
        nodeStack.push(root);
        minStack.push(null);
        maxStack.push(null);
        
        int val;
        Integer min, max;
        TreeNode node;
        while(!nodeStack.isEmpty()) {
            node = nodeStack.pop();
            min = minStack.pop();
            max = maxStack.pop();
            
            // Validate BST condition
            val = node.val;
            if(min != null && val<=min) return false;
            if(max != null && val>=max) return false;
            
            if(node.left != null) {
                nodeStack.push(node.left);
                minStack.push(min);
                maxStack.push(val);
            }
            if(node.right != null) {
                nodeStack.push(node.right);
                minStack.push(val);
                maxStack.push(max);
            }
        }
        
        return true;
        
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }
}