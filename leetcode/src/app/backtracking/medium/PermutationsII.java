package app.backtracking.medium;
import java.util.*;
/**
 * 47. Permutations II
 * https://leetcode.com/problems/permutations-ii/
    Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

    Example 1:

    Input: nums = [1,1,2]
    Output:
    [[1,1,2],
    [1,2,1],
    [2,1,1]]
    Example 2:

    Input: nums = [1,2,3]
    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

    Constraints:
    1 <= nums.length <= 8
    -10 <= nums[i] <= 10
 ****************** Analysis:
 *
 * 1) To controll uniqueness:A key insight to avoid generating any redundant permutation is that at each step rather than viewing each number as a candidate, we consider each unique number as the true candidate. For instance, at the very beginning, given in the input of [1, 1, 2], we have only two true candidates instead of three.
 * 
 *  2) Given the above insight, in order to find out all the unique numbers at each stage, we can build a hash table (denoted as counter), with each unique number as the key and its occurrence as the corresponding value.
 */
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
      
        List<List<Integer>> res = new ArrayList<>(); // return value
        List<Integer> temp = new ArrayList<>();
        
        //Use hashtable to record val and count, so the initial permutation will start from unique numbers
        Map<Integer, Integer> count = new HashMap<>();
        for (int i: nums){
          count.put(i, count.getOrDefault(i, 0) + 1);
        }
        
        backtrack(res, nums.length, count, temp);
        
        return res;
          
      }
    
      private void backtrack(List<List<Integer>> res, int len, Map<Integer, Integer> count, List<Integer> temp){
        // Check if the goal is met
        if(temp.size() == len){
          res.add(new ArrayList<>(temp));
          return;
        }
        
        for (Map.Entry<Integer, Integer> entry: count.entrySet()){
          int val = entry.getKey();
          int counter = entry.getValue();
          
          if (counter == 0) continue;
          
          temp.add(val);
          count.put(val, counter-1);
            
          backtrack(res, len, count, temp);
          
          temp.remove(temp.size()-1);
          count.put(val, counter);
        }
        
      }
    
}
