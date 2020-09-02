package app.linkedlist;

/**
 * Leetcode: Swap Nodes in Pairs
 * Reference: https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1681/
 * Additional Info: tag: linked list; difficulty: medium 
 * ************************** desc:
Given a linked list, swap every two adjacent nodes and return its head.
You may not modify the values in the list's nodes, only nodes itself may be changed.
Example:
Given 1->2->3->4, you should return the list as 2->1->4->3.

 * ************************** analysis:
Recursive Approach.
Complexity Analysis:
Time Complexity: O(N) where N is the size of the linked list.
Space Complexity: O(N) stack space utilized for recursion.
 */

public class SwapNodesInPairsR {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode firstNode = head;
        ListNode secondNode = head.next;
            
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;
        
        return secondNode;
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }
}