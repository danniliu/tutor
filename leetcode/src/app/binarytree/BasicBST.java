package app.binarytree;

/**
 * Leetcode: 701. Insert into a Binary Search Tree
 * Reference: https://leetcode.com/problems/insert-into-a-binary-search-tree/
 * Additional Info: tag: binary tree; difficulty: easy 
 * ************************** Description:
    Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

For example, 

Given the tree:
        4
       / \
      2   7
     / \
    1   3
And the value to insert: 5
You can return this binary search tree:

         4
       /   \
      2     7
     / \   /
    1   3 5
This tree is also valid:

         5
       /   \
      2     7
     / \   
    1   3
         \
          4
 

Constraints:

    The number of nodes in the given tree will be between 0 and 10^4.
    Each node will have a unique integer value from 0 to -10^8, inclusive.
    -10^8 <= val <= 10^8
    It's guaranteed that val does not exist in the original BST.
 * ************************** Analysis:
 * Standard BST insert using resursion, insert at the leaf without considering tree balance
 * Complexity Analysis:
 * Insert:
    Time complexity : O(H), where H is a tree height. That results in O(logN) in the average case, O(N) in the worst case.
    Space complexity : O(H) to keep the recursion stack, O(logN) in the average case, and O(N) in the worst case.
 */

public class BasicBST {
    public TreeNode root;
    BasicBST() {
        root = null;
    }

    public TreeNode insert(int val) {
        return root = insertRec(root, val);
    }
    
    private TreeNode insertRec(TreeNode root, int val){
        //edge cases:
        if (root == null) {
            return new TreeNode(val);
        }
        
        //run down the tree:
        if (val < root.val) {
            root.left = insertRec(root.left, val);
        } else {
            root.right = insertRec(root.right, val);
        }
        
        return root;
    }

    public TreeNode search(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }

        if (val < root.val) {
            return search(root.left, val);
        }

        return search(root.right, val);

    }

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
    
    //in order print:
    public void inOrder(){
        inOrderRec(root);
    }

    private void inOrderRec(TreeNode root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.val);
            inOrderRec(root.right);
        }
    }
    
    public static void main(String[] args) throws Exception {
        BasicBST bst = new BasicBST();
        bst.insert(5);
        bst.insert(4);
        bst.insert(6);
        bst.insert(3);
        bst.insert(7);
        bst.inOrder();
        /*
        TreeNode res = bst.search(bst.root, 35);
        if (res != null) {
            System.out.println(res.val);
        } else {
             System.out.println("not found");
        }*/

        boolean test = bst.isValidBST(bst.root);
        System.out.println(test);
    }
}