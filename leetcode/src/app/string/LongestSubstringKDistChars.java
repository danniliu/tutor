package app.string;

/**
 * Leetcode: 340. Longest Substring with At Most K Distinct Characters
 * Reference: https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * Additional Info: tag: string, hashtable, sliding window; difficulty: hard 
 * ************************** Description:
    Given a string, find the length of the longest substring T that contains at most k distinct characters.

    Example 1:

    Input: s = "eceba", k = 2
    Output: 3
    Explanation: T is "ece" which its length is 3.
    Example 2:

    Input: s = "aa", k = 1
    Output: 2
    Explanation: T is "aa" which its length is 2.
 * ************************** Analysis:
 * Approach 1: Sliding Window + Hashmap:
 * Algorithm
    * Return 0 if the string is empty or k is equal to zero.
    * Set both set pointers in the beginning of the string left = 0 and right = 0 and init max substring length max_len = 1.
    * While right pointer is less than N:
      -- Add the current character s[right] in the hashmap and move right pointer to the right.
      -- If hashmap contains k + 1 distinct characters, remove the leftmost character from the hashmap and move the left pointer so that sliding window contains again k distinct characters only.
      -- Update max_len.
  * Time complexity : 
    -- O(N) in the best case of k distinct characters in the string.
    -- O(Nk) in the worst case of N distinct characters in the string.

  * Space complexity : 
    -- O(k) since additional space is used only for a hashmap with at most k + 1 elements.
 */
import java.util.*;

public class LongestSubstringKDistChars {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if (n*k == 0) return 0;
    
        // sliding window left and right pointers
        int left = 0;
        int right = 0;
        // hashmap character -> its rightmost position 
        // in the sliding window
        HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
    
        int max_len = 1;
    
        while (right < n) {
          // add new character and move right pointer
          hashmap.put(s.charAt(right), right++);
    
          // slidewindow contains 3 characters
          if (hashmap.size() == k + 1) {
            // delete the leftmost character
            int del_idx = Collections.min(hashmap.values());
            hashmap.remove(s.charAt(del_idx));
            // move left pointer of the slidewindow
            left = del_idx + 1;
          }
    
          max_len = Math.max(max_len, right - left);
        }
        return max_len;
      }
    public static void main(String[] args) throws Exception {
        int result = LongestSubstringKDistChars.lengthOfLongestSubstringKDistinct("ececba", 2);
        System.out.println(result);
    }
}