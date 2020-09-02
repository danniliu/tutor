package app.hashtable;

/**
 * Leetcode: 15. 3Sum
 * Reference: https://leetcode.com/problems/3sum/
 * Additional Info: tag: HashTable, Array; difficulty: Medium
 * **************************
    Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
    Note:
    The solution set must not contain duplicate triplets.
    Example:
    Given array nums = [-1, 0, 1, 2, -1, -4],
    A solution set is:
    [
    [-1, 0, 1],
    [-1, -1, 2]
    ]
 * **************************Analysis:
 * This is a two pointer solution
 */
import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums, int target) {
        Set<List<Integer>> res = new HashSet<>();
        int len = nums.length;
        if (len < 3)
            return new ArrayList<>(res);
        
        Arrays.sort(nums);
        
        int start, end, sum;
        for (int i=0; i<len; i++){
            start = i+1;
            end = len -1;
            while (start < end){
                sum = nums[i] + nums[start] +nums[end];
                if(sum == target){
                    res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                } else if (sum > target) {
                    end--;
                }
                else {
                    start++;
                }
            }
        }
        
        return new ArrayList<>(res);
        
    }
    public static void main(String[] args) throws Exception {
        int[] input  = {1,1,2,2,3,3,4,4,5,5};

        List<List<Integer>> result = ThreeSum.threeSum(input, 8);
        
        System.out.println(result.size());
    }
}