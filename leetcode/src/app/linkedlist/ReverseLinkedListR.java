package app.linkedlist;

/**
 * Leetcode: 206. Reverse Linked List
 * Reference: https://leetcode.com/problems/reverse-linked-list/
 * Youtube tutorial with visual animation: https://www.youtube.com/watch?v=MRe3UsRadKw
 * Additional Info: tag: linked list; difficulty: easy 
 * ************************** Description:
    Reverse a singly linked list.

    Example:

    Input: 1->2->3->4->5->NULL
    Output: 5->4->3->2->1->NULL
    Follow up:

    A linked list can be reversed either iteratively or recursively. Could you implement both?
 * ************************** Analysis:
 * This is reversed recursively.
 */

public class ReverseLinkedListR {
    ListNode head;

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        reverseListRecursive(head);
        return this.head;
    }
    
    private void reverseListRecursive(ListNode curr){
        if (curr == null) {
            return;
        }
        
        if(curr.next == null) {
            this.head = curr;
            return;
        }
        
        reverseListRecursive(curr.next);
        curr.next.next = curr;
        curr.next = null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }
}