package app.binarytree;

/**
 * Leetcode: 235. Lowest Common Ancestor of a Binary Search Tree
 * Reference: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * Additional Info: tag: binary tree; difficulty: easy 
 * ************************** Description:
    Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

    Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]


    

    Example 1:

    Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
    Output: 6
    Explanation: The LCA of nodes 2 and 8 is 6.
    Example 2:

    Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
    Output: 2
    Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
    

    Constraints:

    All of the nodes' values will be unique.
    p and q are different and both values will exist in the BST.

 * ************************** Analysis:
 * BST Invariant:
    --> Left subtree of a node N contains nodes whose values are lesser than or equal to node N's value.
    --> Right subtree of a node N contains nodes whose values are greater than node N's value.
    --> Both left and right subtrees are also BSTs.
    
    * Algorithm

    1) Start traversing the tree from the root node.
    2) If both the nodes p and q are in the right subtree, then continue the search with right subtree starting step 1.
    3) If both the nodes p and q are in the left subtree, then continue the search with left subtree starting step 1.
    4) If both step 2 and step 3 are not true, this means we have found the node which is common to node p's and q's subtrees. and hence we return this common node as the LCA.

 * Complexity Analysis
    Time complexity : O(H), where H is a tree height. That results in O(logN) in the average case, O(N) in the worst case.
    Space complexity : O(H) to keep the recursion stack, O(logN) in the average case, and O(N) in the worst case.
 */

public class BSTLCAII {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Value of p
        int pVal = p.val;

        // Value of q;
        int qVal = q.val;

        // Start from the root node of the tree
        TreeNode node = root;

        // Traverse the tree
        while (node != null) {

            // Value of ancestor/parent node.
            int parentVal = node.val;

            if (pVal > parentVal && qVal > parentVal) {
                // If both p and q are greater than parent
                node = node.right;
            } else if (pVal < parentVal && qVal < parentVal) {
                // If both p and q are lesser than parent
                node = node.left;
            } else {
                // We have found the split point, i.e. the LCA node.
                return node;
            }
        }

        return root;
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }
}