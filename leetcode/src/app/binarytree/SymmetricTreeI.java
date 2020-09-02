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
 * This is iterative solution using queue.
 */
import java.util.*;

public class SymmetricTreeI {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
         
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        
        TreeNode n1, n2;
        while(q.size() != 0) {
            n1 = q.poll();
            n2 = q.poll();
            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null) return false;
            if(n1.val != n2.val) return false;
            q.add(n1.left);
            q.add(n2.right);
            q.add(n1.right);
            q.add(n2.left);
        }
        
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }
}