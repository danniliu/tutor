package app.string.palindrome;

import java.util.*;
/**
 * https://www.geeksforgeeks.org/check-characters-given-string-can-rearranged-form-palindrome/
 * Given a string, Check if characters of the given string can be rearranged to form a palindrome. 
    For example characters of “geeksogeeks” can be rearranged to form a palindrome “geeksoskeeg”, but characters of “geeksforgeeks” cannot be rearranged to form a palindrome. 

 ******************* analysis:
    We can do it in O(n) time using a count array. Following are detailed steps. 

    Create a count array of alphabet size which is typically 256. Initialize all values of count array as 0.
    Traverse the given string and increment count of every character.
    Traverse the count array and if the count array has more than one odd values, return false. Otherwise, return true.

 */
public class ScrambledPalindromeII {
    static int NO_OF_CHARS = 256;
    static boolean canFormPalindrome(String str)
    {
        // Create a count array and initialize all
        // values as 0
        int count[] = new int[NO_OF_CHARS];
        Arrays.fill(count, 0);
  
        // For each character in input strings,
        // increment count in the corresponding
        // count array
        for (int i = 0; i < str.length(); i++)
            count[(int)(str.charAt(i))]++;
  
        // Count odd occurring characters
        int odd = 0;
        for (int i = 0; i < NO_OF_CHARS; i++) {
            if ((count[i] & 1) == 1)
                odd++;
  
            if (odd > 1)
                return false;
        }
  
        // Return true if odd count is 0 or 1,
        return true;
    }
  
    // Driver code
    public static void main(String args[])
    {
        if (canFormPalindrome("geeksforgeeks"))
            System.out.println("Yes");
        else
            System.out.println("No");
  
        if (canFormPalindrome("geeksogeeks"))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
    
}
