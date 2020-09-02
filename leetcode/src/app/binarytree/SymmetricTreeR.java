package app.binarytree;

/**
 * Leetcode:  Symmetric Tree
 * Reference: https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/536/
 * Additional Info: tag: binary tree; difficulty: easy 
 * ************************** Description:
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
 * ************************** Analysis:
 * This is recursive solution.
 */

public class SymmetricTreeR {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
         
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSame(root.left, root.right);
    }
    
    boolean isSame(TreeNode n1, TreeNode n2){
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        
        return (n1.val == n2.val)
            && (isSame(n1.left, n2.right))
            && (isSame(n1.right, n2.left));
        
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }
}