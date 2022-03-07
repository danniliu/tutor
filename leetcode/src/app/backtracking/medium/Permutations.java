package app.backtracking.medium;
import java.util.*;
/**
 * 46. Permutations
 * https://leetcode.com/problems/permutations/
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
    Example 1:

    Input: nums = [1,2,3]
    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    Example 2:

    Input: nums = [0,1]
    Output: [[0,1],[1,0]]
    Example 3:

    Input: nums = [1]
    Output: [[1]]

 ****************** Analysis:
    * This is a back track problem
    * good exp of back tracking, C++ example: https://www.youtube.com/watch?v=Nabbpl7y4Lo
    --> 3 keys of backtracking: 
        1) choice  
        2) constraints  
        3) goal
    --> Backtracking recipe:
    void backTrack(res, args){
        if (goal reached)
            add solution to res; return;

        for(int i=0; i<numChoices; i++){
            if(choices[i] is valid) { //based on constraints
                make choices[i]
                backtrack(res, args)
                undo choices[i]
            }
        }
    }

    --> T(n!), exponential, brute force
    --> Backtracking follows DFS approach
    --> Branch and bound follows BFS approach

 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
           List<Integer> ds=new ArrayList<>();
           boolean used[]=new boolean[nums.length];
           backTrack(ans,ds,used,nums);
           return ans;
    }

    public void backTrack(List<List<Integer>> ans,List<Integer> ds,boolean[] used,int[] nums)
    {
        if(ds.size()==nums.length){ // when goal is met
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(used[i]==false) //check constraints
            {
                ds.add(nums[i]); //make choices
                used[i]=true;
                backTrack(ans,ds,used,nums);
                ds.remove(ds.size()-1); //undo choices
                used[i]=false;
            }
        }
    }

    public static void main(String[] args){
        Permutations test = new Permutations();
        int[] input = new int[]{1,2,3};
        List<List<Integer>> res = test.permute(input);
    }
}
