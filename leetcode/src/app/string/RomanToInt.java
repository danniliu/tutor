package app.string;

/**
 * 13. Roman to Integer
 * Reference: https://leetcode.com/problems/roman-to-integer/
 * Additional Info: tag: string; difficulty: easy
 * ************************** Description:
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

Example 1:
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * *************** Analysis:
 * Now, recall that each symbol adds its own value, except for when a smaller valued symbol is before a larger valued symbol. In those cases, instead of adding both symbols to the total, we need to subtract the large from the small, adding that instead.
 * 
 */ 

import java.util.*;

public class RomanToInt {
    static Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
    

   public static int getIntValue(String input){
       //edge case
       if(input == null || input.length() == 0) return 0;
 
       int res = 0;
       int i = 0;
       int n = input.length();
       
       while (i<n){
           int currVal = map.get(input.charAt(i));
           int nextVal = (i+1)<n ? map.get(input.charAt(i+1)) : 0; //smart
           if(nextVal > currVal){
               res = res + nextVal - currVal;
               i=i+2;
           } else { 
               res = res + currVal;
               i++;
           }
           
       }
       
       return res;
       
   }

 public static void main(String[] args) {

        int sum = RomanToInt.getIntValue("MCMIV");
        System.out.println(sum);
   }
}

