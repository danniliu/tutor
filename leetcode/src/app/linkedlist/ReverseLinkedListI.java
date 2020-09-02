package app.linkedlist;

/**
 * Leetcode: 206. Reverse Linked List
 * Reference: https://leetcode.com/problems/reverse-linked-list/
 * Additional Info: tag: linked list; difficulty: easy 
 * ************************** Description:
    Reverse a singly linked list.

    Example:

    Input: 1->2->3->4->5->NULL
    Output: 5->4->3->2->1->NULL
    Follow up:

    A linked list can be reversed either iteratively or recursively. Could you implement both?
 * ************************** Analysis:
 * This is reversed iteratively.
 * Time complexity : O(n). Assume that nn is the list's length, the time complexity is O(n).
 * Space complexity : O(1)
 */

public class ReverseLinkedListI {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode curr, prev = null, temp;
        curr = head;
        while(curr != null){
            //point the next of current node to its previous node
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }
}