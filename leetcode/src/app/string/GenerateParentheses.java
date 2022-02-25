package app.string;
import java.util.*;
/**
 * 22. Generate Parentheses
 * Reference: https://leetcode.com/problems/generate-parentheses/
 * Additional Info: tag: string; difficulty: medium 
 * ************************** Description:
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

    Example 1:

    Input: n = 3
    Output: ["((()))","(()())","(())()","()(())","()()()"]
    Example 2:

    Input: n = 1
    Output: ["()"]
    

    Constraints:

    1 <= n <= 8
 */
public class GenerateParentheses {
     public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisRecursion(n, n, "", result);
        return result;
    }
    
    private void generateParenthesisRecursion(int open, int close, String current, List<String> result) {
        if (open == 0 && close == 0) {
            result.add(current);
            return;
        }
        if (open > 0) {
            generateParenthesisRecursion(open-1, close, current + "(", result);
        }
        
        if (close > 0 && open < close) {
            generateParenthesisRecursion(open, close-1, current + ")", result);
        }
    }


    public static void main(String[] args) throws Exception {
        
        GenerateParentheses test = new GenerateParentheses();
        List<String> res = test.generateParenthesis(3);
       
    }
    
}
