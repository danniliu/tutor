package app.string.palindrome;

/**
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/
 * *********************
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
    Given a string s, return true if it is a palindrome, or false otherwise.

    Example 1:

    Input: s = "A man, a plan, a canal: Panama"
    Output: true
    Explanation: "amanaplanacanalpanama" is a palindrome.
    Example 2:

    Input: s = "race a car"
    Output: false
    Explanation: "raceacar" is not a palindrome.
 * ********************* Analysis:
 * Complexity Analysis

    Time complexity : O(n), in length nn of the string.

    We need to iterate thrice through the string:

    When we filter out non-alphanumeric characters, and convert the remaining characters to lower-case.
    When we reverse the string.
    When we compare the original and the reversed strings.
    Each iteration runs linear in time (since each character operation completes in constant time). Thus, the effective run-time complexity is linear.

    Space complexity : O(n), in length n of the string. We need O(n) additional space to stored the filtered string and the reversed string.
 */

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
    
        for (char ch : s.toCharArray()) {
          if (Character.isLetterOrDigit(ch)) {
            builder.append(Character.toLowerCase(ch));
          }
        }
    
        String filteredString = builder.toString();
        String reversedString = builder.reverse().toString();
    
        return filteredString.equals(reversedString);
      }
    
      /** An alternate solution using Java 8 Streams */
      public boolean isPalindromeUsingStreams(String s) {
        StringBuilder builder = new StringBuilder();
    
        s.chars()
            .filter(c -> Character.isLetterOrDigit(c))
            .mapToObj(c -> Character.toLowerCase((char) c))
            .forEach(builder::append);
    
        return builder.toString().equals(builder.reverse().toString());
      }
}
