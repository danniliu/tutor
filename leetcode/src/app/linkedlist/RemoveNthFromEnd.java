package app.linkedlist;

/**TODO:  Need driver to run the code
 * Leetcode: 19. Remove Nth Node From End of List
 * Reference: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Additional Info: tag: linked list, Two Pointers; difficulty: medium 
 * **************************
   Given a linked list, remove the n-th node from the end of list and return its head.

    Example:
    Given linked list: 1->2->3->4->5, and n = 2.
    After removing the second node from the end, the linked list becomes 1->2->3->5.
    Note:
    Given n will always be valid.
    Follow up:
    Could you do this in one pass?
 * **************************Analysis:
 * This is two passes solution:
 * //return head; --> run time 0 ms; faster than; return  dummy.next; --> run time 1 ms; why???
 * Complexity Analysis
    -- Time complexity : O(L).
    The algorithm makes two traversal of the list, first to calculate list length L and second to find the (L - n)th node. There are 2L-n operations and time complexity is O(L).
    -- Space complexity : O(1).
    We only used constant extra space.
 */

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        if (n == 0) return head;
        
        //1st pass, get the length of the linkedlist
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            size ++;
            temp = temp.next;
        }
        
        //2nd pass, remove the nth
        
        //handle couple special cases
        if(size == 1 && n==1) return null;
        if(size == n) return head.next;
        
        //handle general cases
        size = size - n;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        temp = dummy;
        while(size > 0){
            size = size - 1;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        
        //return head; --> run time 0 ms; faster than; return  dummy.next; --> run time 1 ms; why???
        return head; //or return  dummy.next;
        
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }
}