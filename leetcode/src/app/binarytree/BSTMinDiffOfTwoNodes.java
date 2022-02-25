package app.binarytree;

/**
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 * Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.
 */

public class BSTMinDiffOfTwoNodes {
    Integer ans, prev;
    
    public int minDiffInBST(TreeNode root) {
        prev = null;
        ans = Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }
    
    private void dfs(TreeNode node){
        if (node == null) return;
        dfs(node.left);
        if(prev != null) {
            ans = Math.min(ans, node.val - prev);
        }
        prev = node.val;
        dfs(node.right);
    }
}
