package app.binarytree;

/**
 * Leetcode: Serialize and Deserialize Binary Tree
 * Reference: https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/995/
 * Additional Info: tag: binary tree; difficulty: easy 
 * ************************** Description:
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Example: 
You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 * ************************** Analysis:
 * This is iterative approach, try recursive.
 * I got result: need to debug : [1,2,3,null,null,4,5,null,null,null,null,]
 * 
 */
import java.util.*;

public class SerDesBT {
    
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {   //problem of handling nulls
        if (root == null) return "";
        StringBuilder result = new StringBuilder();
        result.append("[");
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        TreeNode curNode;
        while(!q.isEmpty()){
            curNode = q.poll();

            if(curNode.val == -1){
                result.append("null,");
            } else {
                result.append(Integer.toString(curNode.val)).append(",");
                
                if (curNode.left == null) {
                    q.add(new TreeNode(-1));
                } else {
                    q.add(curNode.left);
                }
                
                if (curNode.right == null) {
                    q.add(new TreeNode(-1));
                } else {
                    q.add(curNode.right);
                }
            }
            
        }
        result.append("]");
        
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) throws NumberFormatException { //this one is good
        if (data.length() <= 0) return null;
        int n = data.length();
        String realData = data.substring(1, n-1);
        String[] dataArr = realData.split(",");
        
        if(dataArr[0].equals("null")) return null;
        TreeNode root, temp, left, right;
        LinkedList<TreeNode> q = new LinkedList<>();
        root = new TreeNode(Integer.parseInt(dataArr[0]));
        q.add(root);
        for (int i=1; i<dataArr.length-1; i=i+2){
            temp = q.poll();
            if(!"null".equals(dataArr[i])) {
                left = new TreeNode(Integer.parseInt(dataArr[i]));
                q.add(left);
                temp.left = left;
            }
            if(!"null".equals(dataArr[i+1])) {
                right = new TreeNode(Integer.parseInt(dataArr[i+1]));
                q.add(right);
                temp.right = right;
            }
        }
         
        return root;
    }

    public static void main(String[] args) throws Exception {
        String input = "[1,2,3,null,null,4,5]";
        TreeNode output = deserialize(input);
        String outputII = serialize(output);
        System.out.println(outputII);
    }
}