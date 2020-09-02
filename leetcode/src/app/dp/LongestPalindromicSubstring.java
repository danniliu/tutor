package app.dp;

/**
 * Leetcode:  5. Longest Palindromic Substring
 * Reference: https://leetcode.com/problems/pascals-triangle-ii/
 * Additional Info: tag: DP; difficulty: medium 
 * **************************
    Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

    Example 1:

    Input: "babad"
    Output: "bab"
    Note: "aba" is also a valid answer.
    Example 2:

    Input: "cbbd"
    Output: "bb"

    * ************************** Analysis:
    1) Brute force time complexity is O(N^3): 3 loops (1st is substring starting point, 2nd is substring ending point, 3rd is check if it is Palindromic substring).
    2) The approach is using DP: Tabulation (Bottom Up) --->iterative
        * We maintain a boolean table[i][j] to memorize if substring (i, j) is Palindromic string, which is filled in bottom up manner. 
        * The value of table[i][j] is true, if the substring is palindrome, otherwise false. 
        * To calculate table[i][j], we first check the value of table[i+1][j-1], if the value is true and str[i] is same as str[j], then we make table[i][j] true. Otherwise, the value of table[i][j] is made false
    3) Time complexity : O(N*N)
    4) Space complexity : O(N)
 */

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return s;
        
        // table[i][j] will be false if substring str[i..j] 
        // is not palindrome. Else table[i][j] will be true 
        boolean table[][] = new boolean[n][n];
        int i, j, k;
        
        int maxLength = 1;
        int start = 0;

        // All substrings of length 1 are palindromes 
        for (i=0; i<n; i++){
            table[i][i] = true;
        }

        // check for sub-string of length 2. 
        for (i=0; i<(n-1); i++){
            if (s.charAt(i) == s.charAt(i+1)) {
                table[i][i+1] = true;  //do I also need to check false?
                maxLength = 2;
                start = i;
            } 
        }
        // Check for lengths greater than 2. k is length 
        // of substring 
        for (k=3; k<=n; k++){
            for (i=0; i+k<=n; i++){
                // Get the ending index of substring from 
                // starting index i and length k 
                j = i + k -1;

                // checking for sub-string from ith index to 
                // jth index iff str.charAt(i+1) to  
                // str.charAt(j-1) is a palindrome
                if ( table[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                    
                     table[i][j] = true;
                     if (Math.max(maxLength, j-i+1) > maxLength){
                        maxLength = Math.max(maxLength, j-i+1);
                        start = i; 
                     }
                } 
            }
        }
        
        return s.substring(start, start+maxLength);
    
    }

    public static void main(String[] args) throws Exception {

        System.out.println(LongestPalindromicSubstring.longestPalindrome("babad"));

    }
}