package app.design;
/**
 * TODO: debug this one
 */
/** 
 * Leetcode: 146. LRU (Least Recently Used) Cache
 * Reference: https://leetcode.com/problems/lru-cache/
 * Additional Info: tag: design/hashtable/linkedlist; difficulty: medium 
 * **************************
   Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

    get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
    put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

    The cache is initialized with a positive capacity.

    Follow up:
    Could you do both operations in O(1) time complexity?

    Example:
    LRUCache cache = new LRUCache(2);  //capacity
    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1);       // returns 1
    cache.put(3, 3);    // evicts key 2
    cache.get(2);       // returns -1 (not found)
    cache.put(4, 4);    // evicts key 1
    cache.get(1);       // returns -1 (not found)
    cache.get(3);       // returns 3
    cache.get(4);       // returns 4

* **************************
    Analysis: 
    1) Use a hashtable that keeps track of the keys and its values in the double linked list.
    2) Double linked list of keys to maintain the least recently used order, most recently used is move to the front, and removal the tail end keys when capacity is reached.Create a Nil head and tail to mark the boundary.
    3) TODO: use below approach to reduce space:
        * The hash table only has key and value;
        * The double linked list keep track of the access order, only key is needed.
*/
import java.util.*;

public class LRUCache {
    int capacity;
    Map<Integer, DlinkedNode> cache = new HashMap<>();
    DlinkedNode head, tail; 
    

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        DlinkedNode node = cache.get(key);
        
        if(node == null) return -1;
        
        //remove the node and add to front
        removeNode(node);
        addNodeToFront(node);
        
        return node.value;
    }
    
    public void put(int key, int value) {
        
        DlinkedNode node = cache.get(key);
            
        if(node == null){
            node =  new DlinkedNode();
            node.key = key;
            node.value = value;
            
            addNodeToFront(node);
            this.cache.put(key, node);
            
            if (cache.size() > capacity){
                DlinkedNode lastNode = popNodeFromBack();
                this.cache.remove(lastNode.key);
            }
            
            
        } else {
            node.value = value;
            addNodeToFront(node);
        }
        
    }
    
    class DlinkedNode{
        int key;
        int value;
        DlinkedNode pre, post;
    }
    
    //Remove a node
    private void removeNode(DlinkedNode node){
        System.out.println("removeNode 1:");
        printList(head);
        DlinkedNode pre = node.pre;
        DlinkedNode post = node.post;
        
        pre.post = post;
        post.pre = pre;
        System.out.println("removeNode 2:");
        printList(head);
        
    }

    //Add the new node right after head;
    private void addNodeToFront(DlinkedNode node){
        if(head != null)  {
            System.out.println("addNodeToFront 1:");
            printList(head);
        }

        if(head == null) {  //first node, init both head and tail, head and tail are dummy pointers
            head = new DlinkedNode();
            head.post =  node;
            node.pre = head;
            tail = new DlinkedNode();
            tail.pre = node;
            node.post =  tail;
        } else {
            DlinkedNode post = head.post;
            
            node.pre = head;
            node.post = post;
            
            head.post = node;
            head.post.pre = node;
        }

        System.out.println("addNodeToFront 2:");
        printList(head);
    }
    
    //Pop the node from the back;
    private DlinkedNode popNodeFromBack(){
        DlinkedNode lastNode = tail.pre;
        removeNode(lastNode);
        
        System.out.println("popNodeFromBack 1:");
        printList(head);

        return lastNode;
    }

    private void printList(DlinkedNode node){
        while(node.post != null){
            System.out.print(node.post.key);
            node = node.post;
        }
    }

    public static void main(String[] args) throws Exception {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4

        System.out.println("Hello Java");
    }
}