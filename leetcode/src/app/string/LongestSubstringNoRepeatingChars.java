package app.string;

import java.util.*;

/**
 * 3. Longest Substring Without Repeating Characters
Medium
-------------------------
Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

----------------- Analysis:
 * sliding window, Time O(n), space O(n)
 * Use Set for no repeating chars
 */

public class LongestSubstringNoRepeatingChars {
    public static int lengthOfLongestSubstring(String s) {
        // edge cases
        if(s == null || s.length() == 0) {
            return 0;
        }
        // DS for process result
        int max = 0;
        int i = 0, j = 0;  //the two pointers
        Set<Character> uniq = new HashSet<>();
        
        while (i < s.length()) {
            char c = s.charAt(i);
            
            while(uniq.contains(c)) { //clear the uniq set and move j to the same level as i
                uniq.remove(s.charAt(j));
                j++;
            }
            
            uniq.add(c);
            max = Math.max(max, i-j+1);
            i++;
            
        }
        
        return max;
        
    }

    public static void main(String[] args) throws Exception {
        
        int test  = LongestSubstringNoRepeatingChars.lengthOfLongestSubstring("pwwkew");
        System.out.println(test);
       
    }
}
