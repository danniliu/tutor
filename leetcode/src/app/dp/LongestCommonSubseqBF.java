package app.dp;

/**
 * Leetcode: 1143. Longest Common Subsequence
 * Reference: https://leetcode.com/problems/longest-common-subsequence/
 * GG reference: https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 * Additional Info: tag: DP; difficulty: medium 
 * ************************** Description:
    Given two strings text1 and text2, return the length of their longest common subsequence.
    A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
    If there is no common subsequence, return 0.

    Examples:
    LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
    LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
    
    Constraints:
    1 <= text1.length <= 1000
    1 <= text2.length <= 1000
    The input strings consist of lowercase English characters only.
 * ************************** Analysis:
 *  1. It is a classic computer science problem, the basis of diff (a file comparison program that outputs the differences between two files), and has applications in bioinformatics.
 *  2. Brute force recursion: time limit exceeded
    --> 1) Consider the input strings “AGGTAB” and “GXTXAYB”. Last characters match for the strings. So length of LCS can be written as:   L(“AGGTAB”, “GXTXAYB”) = 1 + L(“AGGTA”, “GXTXAY”)
    --> 2) Consider the input strings “ABCDGH” and “AEDFHR. Last characters do not match for the strings. So length of LCS can be written as: L(“ABCDGH”, “AEDFHR”) = MAX ( L(“ABCDG”, “AEDFHR”), L(“ABCDGH”, “AEDFH”) )
 
    --> Time complexity: O(2^n)
    --> Space Complexity:  O(1)
 */

public class LongestCommonSubseqBF{
    public int lcs(char[] c1, char[] c2, int m1, int m2){
        //take are of base cases
        if (m1 == 0 || m2 == 0) return 0;

        if (c1[m1 -1] == c2[m2 - 1]) { 
            return 1 + lcs(c1, c2, m1-1, m2-1);
        } else {
            return Math.max(lcs(c1, c2, m1-1, m2), lcs(c1, c2, m1, m2-1));
        }
            
    }
    
    

    public static void main(String[] args) throws Exception {
        LongestCommonSubseqBF item = new LongestCommonSubseqBF();
        String s1 = "AGGTAB"; 
        String s2 = "GXTXAYB"; 
  
        char[] X=s1.toCharArray(); 
        char[] Y=s2.toCharArray(); 
        int m = X.length; 
        int n = Y.length; 

        int result = item.lcs(X, Y, m, n);

        System.out.println(result);
    }
}