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
1) Recursive approach:
2) Time complexity : O(n + m):
Because each recursive call increments the pointer to l1 or l2 by one (approaching the dangling null at the end of each list), there will be exactly one call to mergeTwoLists per element in each list. Therefore, the time complexity is linear in the combined size of the lists.
3)Space complexity : O(n + m)O(n+m)
The first call to mergeTwoLists does not return until the ends of both l1 and l2 have been reached, so n + mn+m stack frames consume O(n + m)O(n+m) space.
 */


public class MergeTwoSortedListsR {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        if(l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
        
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }
}