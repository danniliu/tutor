package app.number.medium;

/**
 * 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/
 * *******************
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    Example 1:
    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]
    Explanation: 342 + 465 = 807.

 * --------------------- Analysis:
 * The pseudocode is as following:
    Initialize current node to dummy head of the returning list.
    Initialize carry to 00.
    Initialize pp and qq to head of l1l1 and l2l2 respectively.
    Loop through lists l1l1 and l2l2 until you reach both ends.
    Set xx to node pp's value. If pp has reached the end of l1l1, set to 00.
    Set yy to node qq's value. If qq has reached the end of l2l2, set to 00.
    Set sum = x + y + carrysum=x+y+carry.
    Update carry = sum / 10carry=sum/10.
    Create a new node with the digit value of (sum \bmod 10)(summod10) and set it to current node's next, then advance current node to next.
    Advance both pp and qq.
    Check if carry = 1carry=1, if so append a new node with digit 11 to the returning list.
    Return dummy head's next node.

 * Complexity Analysis
    Time complexity : O(max(m,n)). Assume that m and n represents the length of l1 and l2 respectively, the algorithm above iterates at most max(m,n) times.
    Space complexity : O(max(m,n)). The length of the new list is at most max(m,n)+1.
 */
public class AddTwoNumbers {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }   
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // dummy head of returning list
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy, p=l1, q=l2;
        
        int carry = 0;
        
        while(p != null || q != null){ // the two linkedlists may have different length
          int x = p!=null ? p.val : 0;
          int y = q!=null ? q.val : 0;
          int sum = x + y + carry;
          carry = sum/10;
          curr.next = new ListNode(sum%10);
          curr = curr.next;
          
          if(p != null) p = p.next;
          if(q != null) q = q.next;
        }
        
        if (carry > 0) {
          curr.next = new ListNode(1);
        }
          
        return dummy.next;
          
      }
}


