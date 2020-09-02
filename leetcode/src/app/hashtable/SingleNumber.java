package app.hashtable;

/**
 * Leetcode: 136. Single Number
 * Reference: https://leetcode.com/problems/single-number/
 * Additional Info: tag: HashTable, Bit Manipulation; difficulty: easy
 * **************************
    Given a non-empty array of integers, every element appears twice except for one. Find that single one.
    Note:
    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

    Example 1:
    Input: [2,2,1]
    Output: 1

    Example 2:
    Input: [4,1,2,1,2]
    Output: 4
* ************************** Analysis:
    This hash table implementation used extra memory, SingleNumberII is a simpler implementation.
 */
import java.util.*;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        //HashMap to store value and count
        HashMap<Integer, Integer> valCount =  
                     new HashMap<Integer, Integer>(); 
        
        for (int i=0; i<nums.length; i++){
            valCount.put(nums[i], valCount.getOrDefault(nums[i], 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> mapItem : valCount.entrySet()){
            if((int)mapItem.getValue() == 1) {
                return (int)mapItem.getKey();
            }
        }
        
        return 0;
    }
    public static void main(String[] args) throws Exception {
        int[] nums = {2,2,1};
        int result = singleNumber(nums);
        System.out.println(result);
    }
}