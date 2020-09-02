package app.hashtable;

/**
 * Leetcode: 136. Single Number
 * Reference: https://leetcode.com/problems/single-number/
 * Additional Info: tag: HashTable, Bit Manipulation; difficulty: easy
 * Notes: This hash table implementation used extra memory, it is a simpler one than SingleNumber.
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
 */
import java.util.*;

public class SingleNumberII {
    public static int singleNumber(int[] nums) {
        //HashMap to store value and count
        HashMap<Integer, Integer> valCount =  new HashMap<>(); 

        for (int i=0; i<nums.length; i++){
            if ( valCount.containsKey(nums[i])) {
                valCount.remove(nums[i]);
            } else {
                valCount.put(nums[i], 1);
            }
        }

        for(Integer j: valCount.keySet()){
            return j;
        }

        return 0;
    }
    public static void main(String[] args) throws Exception {
        int[] nums = {2,2,1};
        int result = singleNumber(nums);
        System.out.println(result);
    }
}