package app.heap;

/**
 * Leetcode: 703. Kth Largest Element in a Stream
 * Reference: https://leetcode.com/problems/kth-largest-element-in-a-stream/
 * Additional Info: tag: heap; difficulty: easy 
 * ************************** Description:
    Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

    Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.

    Example:

    int k = 3;
    int[] arr = [4,5,8,2];
    KthLargest kthLargest = new KthLargest(3, arr);
    kthLargest.add(3);   // returns 4
    kthLargest.add(5);   // returns 5
    kthLargest.add(10);  // returns 5
    kthLargest.add(9);   // returns 8
    kthLargest.add(4);   // returns 8
    Note:
    You may assume that nums' length ≥ k-1 and k ≥ 1.
 * ************************** Analysis:
 * Time Complexity: O(NlogN)
 * Space Complexity: O(N)
 */
import java.util.*;

public class TopKElementInAStream {
    int len = 0;
    PriorityQueue<Integer> pq; 

    public TopKElementInAStream(int k, int[] nums) {
        len = k;
        pq = new PriorityQueue<>(); //Init the heap as default min heap
        //In order to maintain the heap as min heap with k largest elements
        //Manully remove the smallest element from the root
        for(int num: nums){  
            pq.add(num);
            if(pq.size() > len) {
                pq.remove();
            }
        }
        
    }

    public int add(int val) {
        if (pq.size() == len){
            if(val > pq.peek()){
                pq.remove();
                pq.add(val);
            }
            
        } else {
            pq.add(val);
        }
        
        return pq.peek();
        
    }
    public static void main(String[] args) throws Exception {
        int[] nums = {4,5,8,2};
        TopKElementInAStream topK = new TopKElementInAStream(3, nums);
        int result = topK.add(3);
        System.out.println(result);
    }
}