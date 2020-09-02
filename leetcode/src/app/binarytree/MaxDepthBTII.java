package app.binarytree;

/**
 * Leetcode: maximum depth of Binary Tree
 * Reference: https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/535/
 * Additional Info: tag: binary tree; difficulty: easy 
 * ************************** Description:
   The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

    Note: A leaf is a node with no children.
    Example:
    Given binary tree [3,9,20,null,null,15,7],
         3
        / \
        9  20
          /  \
         15   7
    return its depth = 3.
 * ************************** Analysis:
 * This is bottom-up recursion
 */

public class MaxDepthBTII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
         
    }
    
    public int maxDepth(TreeNode root) {
        return _maxDepth(root);
        
    }
    
    private int _maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        return Math.max(_maxDepth(root.left), _maxDepth(root.right)) + 1;
    } 

    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }
}