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
 * Approach 2: Sliding Window + LinkedHashMap:
 * Analysis:
    Approach 1 with a standard hashmap couldn't ensure O(N) time complexity.
    To have O(N) algorithm performance, one would need a structure, which provides four operations in O(1) time :
      Insert the key
      Get the key / Check if the key exists
      Delete the key
      Return the first / or the last added key/value
    The first three operations in O(1) time are provided by the standard hashmap, and the forth one - by linked list, in java LinkedHashMap.
 * Algorithm
    * Return 0 if the string is empty or k is equal to zero.
    * Set both set pointers in the beginning of the string left = 0 and right = 0 and init max substring length max_len = 1.
    * While right pointer is less than N:
      -- If the current character s[right] is already in the ordered dictionary hashmap -- delete it, to ensure that the first key in hashmap is the leftmost character.
      -- Add the current character s[right] in the ordered dictionary and move right pointer to the right.
      -- If ordered dictionary hashmap contains k + 1 distinct characters, remove the leftmost one and move the left pointer so that sliding window contains again k distinct characters only.
      -- Update max_len.

  * Time complexity : 
    -- O(N) since all operations with ordered dictionary : insert/get/delete/popitem (put/containsKey/remove) are done in a constant time.

  * Space complexity : 
    -- O(k) since additional space is used only for a hashmap with at most k + 1 elements.
 */
import java.util.*;

public class LongestSubstringKDistCharsII {
  public static int lengthOfLongestSubstringKDistinct(String s, int k) {
    int n = s.length();
    if (n*k == 0) return 0;

    // sliding window left and right pointers
    int left = 0;
    int right = 0;
    // hashmap character -> its rightmost position 
    // in the sliding window
    LinkedHashMap<Character, Integer> hashmap = new LinkedHashMap<Character, Integer>(k + 1);

    int max_len = 1;

    while (right < n) {
      Character character = s.charAt(right);
      // if character is already in the hashmap -
      // delete it, so that after insert it becomes
      // the rightmost element in the hashmap
      if (hashmap.containsKey(character))
        hashmap.remove(character);
      hashmap.put(character, right++);

      // slidewindow contains k + 1 characters
      if (hashmap.size() == k + 1) {
        // delete the leftmost character
        Map.Entry<Character, Integer> leftmost = hashmap.entrySet().iterator().next();
        hashmap.remove(leftmost.getKey());
        // move left pointer of the slidewindow
        left = leftmost.getValue() + 1;
      }

      max_len = Math.max(max_len, right - left);
    }
    return max_len;
  }


    public static void main(String[] args) throws Exception {
        int result = LongestSubstringKDistCharsII.lengthOfLongestSubstringKDistinct("ececba", 2);
        System.out.println(result);
    }
}