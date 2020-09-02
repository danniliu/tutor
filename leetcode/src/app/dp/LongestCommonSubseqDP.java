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
 *  2.  This solution uses DP Tabulation (Bottom Up) --->iterative, use dp[m+1][n+1], dp[i][j] memorizes
LCS (Longest Common Subsequence) of 0 length (index is 0) to ith char (index is i-1) for text1 and 
0 length (index is 0) to jth char (index is j-1) for text2
    --> 1) Consider the input strings “AGGTAB” and “GXTXAYB”. Last characters match for the strings. So length of LCS can be written as:   L(“AGGTAB”, “GXTXAYB”) = 1 + L(“AGGTA”, “GXTXAY”)
    --> 2) Consider the input strings “ABCDGH” and “AEDFHR. Last characters do not match for the strings. So length of LCS can be written as: L(“ABCDGH”, “AEDFHR”) = MAX ( L(“ABCDG”, “AEDFHR”), L(“ABCDGH”, “AEDFH”) )
 
    --> Time complexity: O(mn)
    --> Space Complexity:  O(mn)
 */

public class LongestCommonSubseqDP{

    public int longestCommonSubsequence(String text1, String text2) {
        // take care of expcetions
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0)
            return 0;
            
        char[] c1 = text1.toCharArray();
        int m = c1.length;
        char[] c2 = text2.toCharArray();
        int n = c2.length;
            
        /* Following steps build dp[m+1][n+1] in bottom up fashion. Note 
         that dp[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
        int[][] dp = new int[m+1][n+1];
        
        for(int i=0; i<=m; i++){
            
            for(int j=0; j<=n; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                } else if (c1[i-1] == c2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
                
            }
            
        }
            
        return dp[m][n];
        
    }
    
    public static void main(String[] args) throws Exception {
        LongestCommonSubseqDP item = new LongestCommonSubseqDP();
        String s1 = "AGGTAB"; 
        String s2 = "GXTXAYB"; 
  
        int result = item.longestCommonSubsequence(s1, s2);

        System.out.println(result);
    }
}