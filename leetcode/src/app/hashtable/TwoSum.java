package app.hashtable;

/**
 * Leetcode: 1. Two Sum
 * Reference: https://leetcode.com/problems/two-sum/
 * Additional Info: tag: HashTable, Array; difficulty: easy
 * **************************
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    Example:
    Given nums = [2, 7, 11, 15], target = 9,
    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
 * **************************Analysis:
 * This is a hashtable solution.
 * Time complexity: O(n). We traverse the list containing nn elements only once. Each lookup in the table costs only O(1) time.
 * Space complexity: O(n). The extra space required depends on the number of items stored in the hash table, which stores at most n elements.
 */
import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> table = new HashMap<>();
            
        for(int i=0; i<len; i++) {
            int pair = target - nums[i];
            if (table.containsKey(pair)) {
                return new int[]{i, table.get(pair)};
            } else {
                table.put(nums[i], i);
            }
            
        }
        
        return null;
    }
    public static void main(String[] args) throws Exception {
        
        System.out.println("0");
    }
}