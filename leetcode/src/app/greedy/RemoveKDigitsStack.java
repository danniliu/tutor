package app.greedy;

import java.util.*;

/**
 * Leetcode: 402. Remove K Digits
 * Reference: https://leetcode.com/problems/remove-k-digits/
 * Additional Info: tag: greedy; difficulty: medium 
 * **************************
    Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

    Note:
    The length of num is less than 10002 and will be ≥ k.
    The given num does not contain any leading zero.
    Example 1:

    Input: num = "1432219", k = 3
    Output: "1219"
    Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
    Example 2:

    Input: num = "10200", k = 1
    Output: "200"
    Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
    Example 3:

    Input: num = "10", k = 2
    Output: "0"
    Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 * ************************** Analysis:
 * This is a stack impementation of the greedy algorithm.
 * This greedy algorithm fail to address the test case of "1234567000" and remove 8, when there are small numbers in the end
 */

public class RemoveKDigitsStack {

    public static String removeKdigits(String num, int k) {
        //take care of couple edge cases
        if (k == 0) return num;
        if (num.length() == k) return "0";
        
        //Initiate the stack
        LinkedList<Character> stack = new LinkedList<>();
        
        //The greedy algorithm is to remove the number from left if it is greater than the next number
        //This greedy algorithm fail to address the test case of "1234567000" and remove 8, when there are small numbers in the end
        for(char c: num.toCharArray()){
            if(stack.size()>0 && k>=0 && stack.peekLast()>c){
                stack.removeLast();
                k = k-1;
            }
            stack.addLast(c);
        }
        
        //If the not all K numbers are removed, remove the rest from then end
        for(int i=0; i<k; i++){
            stack.removeLast();
        }
        
        //Remove leading zeros if any
        StringBuilder ret = new StringBuilder();
        boolean removeLeadingZero = true;
        for(char c: stack){
            if(removeLeadingZero && c =='0') continue;
            removeLeadingZero = false;
            ret.append(c);
        }
        
        //return "0" if all numbers are removed, based on the requirement
        if(ret.length() == 0) return "0";  
        
        return ret.toString();
        
    }

    public static void main(String[] args) throws Exception {

        String rooms = RemoveKDigitsStack.removeKdigits("1432219", 3);
        System.out.print(rooms);
    }
}