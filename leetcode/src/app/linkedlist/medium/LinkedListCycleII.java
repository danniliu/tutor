package app.linkedlist.medium;
import app.linkedlist.ListNode;

/**
 * Leetcode: 142. Linked List Cycle II
 * Reference: https://leetcode.com/problems/linked-list-cycle-ii/
 * Additional Info: tag: linked list
 * linked list runner technique:
    https://jaykalia07.medium.com/linked-lists-and-the-runner-technique-8e70e5433389
    https://www.youtube.com/watch?v=MFOAbpfrJ8g

 * ************************** Description:
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * ------------------ Analysis:
 * Let’s give a brief intro to Floyd’s Cycle-Finding Algorithm
    Traverse linked list using two pointers.
    Move one pointer(slow) by one and another pointer(fast) by two.
    If these pointers meet at the same node then there is a loop. If pointers do not meet then linked list doesn’t have a loop.
    Time complexity: O(n).
    Only one traversal of the loop is needed.
    Auxiliary Space:O(1).
    There is no space required.
 */

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }

        ListNode fast = head, slow = head;
        while (slow != null && fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }

        if (fast == null || fast.next == null) return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
