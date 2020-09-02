package app.backtracking;

/**
 * Leetcode: 17. Letter Combinations of a Phone Number
 * Reference: Geekforgeeks: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Additional Info: tag: backtracking; difficulty: medium 
 * ************************** Description:
	Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

	A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters (refer to the digit to letters mapping in the java file).

	Example:

	Input: "23"
	Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
	Note:

	Although the above answer is in lexicographical order, your answer could be in any order you want.
 * ************************** Analysis:
 * This is using back tracking.
 */

import java.util.*;

public class PhoneNumberLetterCombo { 
	HashMap<String, String> phoneMap;
    List<String> res;

    public PhoneNumberLetterCombo() {
        phoneMap = new HashMap<>();
        phoneMap.put("2", "abc");
        phoneMap.put("3", "def");
        phoneMap.put("4", "ghi");
        phoneMap.put("5", "jkl");
        phoneMap.put("6", "mno");
        phoneMap.put("7", "pqrs");
        phoneMap.put("8", "tuv");
        phoneMap.put("9", "wxyz");

        res = new ArrayList<>();

    }
    
    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backTrack("", digits);
        return res;
    }
    
    void backTrack(String combo, String nextDigits) {
        if(nextDigits.length() == 0){
            res.add(combo);
        } else {
            String digit = nextDigits.substring(0, 1);
            String letters = phoneMap.get(digit);
            for (int i=0; i<letters.length(); i++){
                String letter = letters.substring(i, i+1);
                backTrack(combo + letter, nextDigits.substring(1));
            }
            
        }
        
    }

	// driver program to test above function 
	public static void main(String args[]) 
	{ 
		PhoneNumberLetterCombo combo = new PhoneNumberLetterCombo(); 
		List<String> result = combo.letterCombinations("23"); 
		for(String item: result){
			System.out.print(item + " ");
		}
	} 
} 