package app.linkedlist;

/**
 * Leetcode: 23. Merge k Sorted Lists:
 * Reference: https://leetcode.com/problems/merge-k-sorted-lists/
 * Additional Info: tag: linked list, divide and conquer, heap; difficulty: hard 
 * ************************** Description:
    Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

    Example:

    Input:
    [
    1->4->5,
    1->3->4,
    2->6
    ]
    Output: 1->1->2->3->4->4->5->6
 * ************************** Analysis:
 Time complexity : O(Nlogk) where k is the number of linked lists.
    The comparison cost will be reduced to O(\log k)O(logk) for every pop and insertion to priority queue. But finding the node with the smallest value just costs O(1)O(1) time.
    There are NN nodes in the final linked list.
Space complexity :
    O(n) Creating a new linked list costs O(n)O(n) space.
    O(k) The code above present applies in-place method which cost O(1) space. And the priority queue (often implemented with heaps) costs O(k) space (it's far less than N in most situations).
 */
import java.util.*;

public class MergeKSortedLists {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        //Create a min heap:
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        ListNode ptr, head;
        
        //Put the value to the heap
        for(ListNode list : lists){
            while(list != null){
                pq.add(list.val);
                list = list.next;
            }
        }
        
        ptr = new ListNode(-1); //create a dummy head
        head = ptr;
        
        while(pq.size() != 0) {
            head.next = new ListNode(pq.poll());
            head = head.next;
        }
        
        return ptr.next;
        
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }
}