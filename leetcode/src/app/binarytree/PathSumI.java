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
 * This is iterative solution.
 * Complexity Analysis
Time complexity : the same as the recursion approach \mathcal{O}(N)O(N).
Space complexity : \mathcal{O}(N)O(N) since in the worst case, when the tree is completely unbalanced, e.g. each node has only one child node, we would keep all NN nodes in the stack. But in the best case (the tree is balanced), the height of the tree would be \log(N)log(N). Therefore, the space complexity in this case would be \mathcal{O}(\log(N))O(log(N)).
 */
import java.util.*;

public class PathSumI {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
         
    }
    
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        
        LinkedList<TreeNode> nodeStack = new LinkedList<>();
        LinkedList<Integer> sumStack = new LinkedList<>();
        
        nodeStack.add(root);
        sumStack.add(sum - root.val);
        
        TreeNode curNode;
        int curSum;
        while(!nodeStack.isEmpty()) {
            curNode = nodeStack.pollLast();
            curSum = sumStack.pollLast();
            if(curSum==0 && curNode.left==null && curNode.right==null) return true;
            
            if(curNode.left != null){
                nodeStack.add(curNode.left);
                sumStack.add(curSum - curNode.left.val);
            }
            
            if(curNode.right != null){
                nodeStack.add(curNode.right);
                sumStack.add(curSum - curNode.right.val);
            }
        }
        
        return false;
        
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }
}