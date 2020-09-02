package app.greedy;

/**
 * Leetcode: 767. Reorganize String
 * Reference: https://leetcode.com/problems/reorganize-string/
 * Additional Info: tag: String, Heap, Greedy, Sort; difficulty: medium 
 * ************************** Description:
    Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

    If possible, output any possible result.  If not possible, return the empty string.

    Example 1:

    Input: S = "aab"
    Output: "aba"
    Example 2:

    Input: S = "aaab"
    Output: ""
 * ************************** Analysis:
 */
import java.util.*;

public class ReorganizeString {
    public static String reorganizeString(String S) {
        Map<Character, Integer> counts = new HashMap<>();
        
        
        for(char c: S.toCharArray()){
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b)->(counts.get(b)-counts.get(a)));
        maxHeap.addAll(counts.keySet());  
        
        StringBuilder result = new StringBuilder();
        while(maxHeap.size() > 1){
            char current = maxHeap.remove();
            char next = maxHeap.remove();
            result.append(current).append(next);
            counts.put(current, counts.get(current) - 1);
            counts.put(next, counts.get(next) - 1);
            if (counts.get(current) >0) {
                maxHeap.add(current);
            }
            if (counts.get(next) >0) {
                maxHeap.add(next);
            }
        }
        
        if (!maxHeap.isEmpty()){
            char last = maxHeap.remove();
            if (counts.get(last) > 1)
                return "";
            else
                result.append(last);
        }
        
        return result.toString();
        
    }
    public static void main(String[] args) throws Exception {
        String result = reorganizeString("aab");
        System.out.println(result);
    }
}