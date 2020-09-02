package app.binarytree;

/**
 * Leetcode: Path Sum
 * Reference: https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/537/
 * Additional Info: tag: binary tree; difficulty: easy 
 * ************************** Description:
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
Note: A leaf is a node with no children.

Example:
Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * ************************** Analysis:
 * This is recursion
 */

public class PathSumR {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
         
    }
    boolean match =  false;
    
    public boolean hasPathSum(TreeNode root, int sum) {
        pathSum(root, 0, sum);
        return match;
    }
    
    void pathSum(TreeNode root, int pathSum, int sum){
        if(root == null) return;
        
        pathSum = pathSum + root.val;
        if(pathSum == sum) {
            if(root.left == null && root.right == null) {
                match = true;
                return;
            }
        }
        
        pathSum(root.right, pathSum, sum);
        pathSum(root.left, pathSum, sum);
        
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }
}