package app.linkedlist;

/**
 * Leetcode: 25. Reverse Nodes in k-Group
 * Reference: https://leetcode.com/problems/reverse-nodes-in-k-group/
 * Additional Info: tag: linked list; difficulty: hard 
 * ************************** Description:
    Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
    k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

    Example:
    Given this linked list: 1->2->3->4->5
    For k = 2, you should return: 2->1->4->3->5
    For k = 3, you should return: 3->2->1->4->5

    Note:
    Only constant extra memory is allowed.
    You may not alter the values in the list's nodes, only nodes itself may be changed.
 */

public class ReverseLinkedListInKGroup {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k<=0) return head;
        
        ListNode curr;
        ListNode newHead = null;
        ListNode preGroupTail = null;
        int length = 0;
        
        //get the length of the linked list
        curr = head;
        while(curr != null) {
            length++;
            curr = curr.next;
        }
        
        curr = head;
        while(true){
            if (length >= k) {
                // if the current length is greater than k, we can do the swap
                // first group will be 1->2 and we want it swapped to 2->1
                // thus, the tail after reverse is the head, and the head after reverse is the tail
                ListNode groupHead = null;
                ListNode groupTail = curr;
                ListNode temp = null;
                
                for(int i=0; i<k; i++){
                    temp = curr.next;
                    curr.next = groupHead;
                    groupHead = curr;
                    curr = temp;
                }
                length = length - k;
                
                // in first iteration, the result will be 2->1->null 3->4->5, the curr now pointing at 3
                // since we have empty new head, we store the new head as reversed head, and prev tail as reversed tail
                if (newHead == null){ 
                    newHead = groupHead;
                    preGroupTail = groupTail;
                }
                // in the second iteration, the result will be 2->1->null 4->3->null 5
                // so we need to connect the prev tail 1 to curr reversed head 4, and so on
                else {
                    preGroupTail.next = groupHead;
                    preGroupTail = groupTail;
                }
                
            } else {
                preGroupTail.next = curr;
                break;
            }
        }
        
        
        return newHead;
    }
}