package app.linkedlist;

/**
 * Leetcode: Merge Two Sorted Lists:
 * Reference: https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/2382/
 * Additional Info: tag: linked list; difficulty: easy 
 * ************************** Description:
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 * ************************** Analysis:
1) Iterative approach:
2) Time complexity : O(n + m):
Because exactly one of l1 and l2 is incremented on each loop iteration, the while loop runs for a number of iterations equal to the sum of the lengths of the two lists. All other work is constant, so the overall complexity is linear.
3) Space complexity : O(1):
The iterative approach only allocates a few pointers, so it has a constant overall memory footprint.
 */

public class MergeTwoSortedListsI {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        // Create a pointer
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            
            pre = pre.next;
            
        }
        
        pre.next = (l1 == null)? l2 : l1;
        
        return dummy.next;
        
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }
}