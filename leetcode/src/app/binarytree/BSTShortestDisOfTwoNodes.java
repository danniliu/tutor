package app.binarytree;

/**
 * Leetcode: a701: Construct BST and find the distance between two notes (tree, medium), this is an Amazon OA problem.
 * Reference: https://leetcode.com/discuss/interview-question/376375/
 * --> GG:  https://www.geeksforgeeks.org/shortest-distance-between-two-nodes-in-bst/
 * Additional Info: tag: binary tree; difficulty: easy 
 * ************************** Description:
    Given a list of unique integers nums, construct a BST from it (you need to insert nodes one-by-one with the given order to get the BST) and find the distance between two nodes node1 and node2. Distance is the number of edges between two nodes. If any of the given nodes does not appear in the BST, return -1.

    Example 1:

    Input: nums = [2, 1, 3], node1 = 1, node2 = 3
    Output: 2
    Explanation:
     2
   /   \
  1     3

 * ************************** Analysis:
 * BST Invariant:
    --> Left subtree of a node N contains nodes whose values are lesser than or equal to node N's value.
    --> Right subtree of a node N contains nodes whose values are greater than node N's value.
    --> Both left and right subtrees are also BSTs.
    
    * Algorithm

    1) If both keys are greater than the current node, we move to the right child of the current node.
    2) If both keys are smaller than current node, we move to left child of current node.
    3) If one keys is smaller and other key is greater, current node is Lowest Common Ancestor (LCA) of two nodes. We find distances of current node from two keys and return sum of the distances.

 * Complexity Analysis
    Time complexity : O(H), where H is a tree height. That results in O(logN) in the average case, O(N) in the worst case.
    Space complexity : O(H) to keep the recursion stack, O(logN) in the average case, and O(N) in the worst case.
 */

public class BSTShortestDisOfTwoNodes {
    public TreeNode insert(TreeNode root, int val){
        if (root == null) return new TreeNode(val);

        if(val < root.val) { //insert to the left
            root.left =  insert(root.left, val);
        } else { //insert to the right
            root.right =  insert(root.right, val);
        }

        return root;
    }

    // This function returns distance of x from  root. This function assumes that x exists  
    // in BST and BST is not NULL.  
    private int distanceFromRoot(TreeNode root, int x){
        if(x == root.val) return 0;
        else if(x < root.val) 
            return 1 + distanceFromRoot(root.left, x);
        else 
            return 1 + distanceFromRoot(root.right, x);
    }

    public int shortestDistOfTwoNodes(TreeNode root, int p, int q) {
        
        //if both nodes are in the left side of root
        if(p < root.val && q < root.val)
            return shortestDistOfTwoNodes(root.left, p, q);
        
        //if both nodes are in the righ side of root
        if(p > root.val && q > root.val)
            return shortestDistOfTwoNodes(root.right, p, q);

        //if the two nodes are in the two side of root, the root is the LCA
        if( (p >= root.val && q <= root.val) ||
            (p <= root.val && q >= root.val) )
            return distanceFromRoot(root, p) +distanceFromRoot(root, q);

        return 0;
    }
    
    public static void main(String[] args) throws Exception {
        BSTShortestDisOfTwoNodes bst = new BSTShortestDisOfTwoNodes();

        TreeNode root = null;  
        root = bst.insert(root, 20);  
        bst.insert(root, 10);  
        bst.insert(root, 5);  
        bst.insert(root, 15);  
        bst.insert(root, 30);  
        bst.insert(root, 25);  
        bst.insert(root, 35);  
        System.out.println(bst.shortestDistOfTwoNodes(root, 5, 35)); 
    }
}