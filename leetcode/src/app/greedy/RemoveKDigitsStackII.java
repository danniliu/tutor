package app.greedy;


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
 * This one use stringbuilder on the impementation of the greedy algorithm, pass all test cases, but kind of slow.
 * replace stringbuilder(34 ms) with  arraylist (22ms) make it slightly faster.
 */

public class RemoveKDigitsStackII {

    public String removeKdigits(String num, int k) {
        
        if(k == num.length()){
            return "0";
        }
        
        StringBuilder sb = new StringBuilder(num);

        int idx;
        //remove k chars if the char is greate than its neighbor on the right
        for(int i = 0; i < k; i++){
            idx = 0;
            while((idx < sb.length() - 1) && (sb.charAt(idx) <= sb.charAt(idx + 1))){
                idx++;
            }
            sb.deleteCharAt(idx);
        }
        
        //remove leading zeros
        idx = 0;
        while(sb.length()>0 && sb.charAt(idx) == '0') {
            sb.deleteCharAt(idx);
        }

        if(sb.length() == 0) return "0";
        else return sb.toString();
    
    }

    public static void main(String[] args) throws Exception {

        String rooms = RemoveKDigitsStack.removeKdigits("1432219", 3);
        System.out.print(rooms);
    }
}