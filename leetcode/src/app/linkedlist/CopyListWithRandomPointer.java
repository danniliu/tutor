package app.linkedlist;

/**TODO:  Need driver to run the code
 * Leetcode: 138. Copy List with Random Pointer
 * Reference: https://leetcode.com/problems/copy-list-with-random-pointer/
 * Additional Info: tag: linked list; difficulty: medium 
 * **************************
    A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

    Return a deep copy of the list.

    The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

    val: an integer representing Node.val
    random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
 */

public class CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        //create a new weaved list of original and copied node
        Node ptr = head;
        while(ptr != null) {
            Node newNode = new Node(ptr.val);
            
            // Inserting the cloned node just next to the original node.
            // If A->B->C is the original linked list,
            // Linked list after weaving cloned nodes would be A->A'->B->B'->C->C'
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }
        
        ptr = head;
        // Now link the random pointers of the new nodes created.
        // Iterate the newly created list and use the original nodes' random pointers,
        // to assign references to random pointers for cloned nodes.
        while (ptr!=null){
            ptr.next.random = (ptr.random != null)? ptr.random.next: null;
            ptr = ptr.next.next;
        }
        
        //Unweave the lined list to get back the original lined list and the cloned list
        // i.e. A->A'->B->B'->C->C' would be broken to A->B->C and A'->B'->C'
        Node ptr_old_list = head; //A->B->C
        Node ptr_new_list = head.next; //A'->B'->C'
        Node head_new = head.next;
        while(ptr_old_list != null){
            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = (ptr_new_list.next != null)? ptr_new_list.next.next: null;
            ptr_old_list = ptr_old_list.next;
            ptr_new_list = ptr_new_list.next;
        }
        
        return head_new;
        
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }
}