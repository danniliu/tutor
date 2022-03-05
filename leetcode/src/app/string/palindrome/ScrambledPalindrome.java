package app.string.palindrome;
import java.util.*;
/**
 * https://www.geeksforgeeks.org/check-characters-given-string-can-rearranged-form-palindrome/
 * Given a string, Check if characters of the given string can be rearranged to form a palindrome. 
    For example characters of “geeksogeeks” can be rearranged to form a palindrome “geeksoskeeg”, but characters of “geeksforgeeks” cannot be rearranged to form a palindrome. 

 ******************* analysis:
    We can do it in O(n) time using a list. Following are detailed steps. 
    Create a character list.
    Traverse the given string.
    For every character in the string, remove the character if the list already contains else add to the list.
    If the string length is even the list is expected to be empty.
    Or if the string length is odd the list size is expected to be 1
    On the above two conditions (3) or (4) return true else return false.

 */
public class ScrambledPalindrome {
    static boolean canFormPalindrome(String str)
    {
  
        // Create a list
        List<Character> list = new ArrayList<Character>();
  
        // For each character in input strings,
        // remove character if list contains
        // else add character to list
        for (int i = 0; i < str.length(); i++) 
        {
            if (list.contains(str.charAt(i)))
                list.remove((Character)str.charAt(i));
            else
                list.add(str.charAt(i));
        }
  
        // if character length is even 
        // list is expected to be empty or 
        // if character length is odd list size 
        // is expected to be 1
        
        
        // if string length is even
        if (str.length() % 2 == 0
                && list.isEmpty() 
            || (str.length() % 2 == 1
                && list.size()
                       == 1)) 
            return true;
        
        // if string length is odd
        else
            return false;
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
