package app.dp;

/**
 * Leetcode:  119. Pascal's Triangle II
 * Reference: https://leetcode.com/problems/pascals-triangle-ii/
 * Additional Info: tag: DP; difficulty: easy 
 * This solution uses dynamic programming
 * **************************
    Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
    Note that the row index starts from 0.

    In Pascal's triangle, each number is the sum of the two numbers directly above it.

    Example:

    Input: 3
    Output: [1,3,3,1]
    Follow up:

    Could you optimize your algorithm to use only O(k) extra space?

    Approach 1: Brute Force Recursion
    Intuition

    We'll utilize a nice little property of Pascal's Triangle (given in the problem description):



    In Pascal's triangle, each number is the sum of the two numbers directly above it.

    Approach 4 will expand more on why it is so.

    Algorithm

    Let's say we had a function getNum(rowIndex, colIndex), which gave us the colIndexth number in the rowIndexth row, we could simply build the k^{th}k 
    th
    row by repeatedly calling getNum(...) for columns 00 to kk.

    We can formulate our intuition into the following recursion:

    \text{getNum(rowIndex, colIndex) = getNum(rowIndex-1, colIndex-1) + getNum(rowIndex-1, colIndex)}getNum(rowIndex, colIndex) = getNum(rowIndex-1, colIndex-1) + getNum(rowIndex-1, colIndex)

    The recursion ends in some known base cases:

    The first row is just a single 11, i.e. \text{getNum(0, ...) = 1}getNum(0, ...) = 1

    The first and last number of each row is 11, i.e. \text{getNum(k, 0) = getNum(k, k) = 1}getNum(k, 0) = getNum(k, k) = 1

    * ************************** Analysis:
    It is worth noting that generating a number for a particular row requires only two numbers from the previous row. Consequently, generating a row only requires numbers from the previous row.

    Thus, we could reduce our memory footprint by only keeping the latest row generated, and use that to generate a new row.
    Time complexity : O(k^2)
    Space complexity : O(k) + O(k) ≃O(k).
 */
import java.util.*;

public class PascalTriangleII {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<=rowIndex; i++){
            ans.add(getNum(rowIndex, i));
        }
        
        return ans;
        
    }
    
    public static int getNum(int rowIndex, int colIndex){
        if(rowIndex == 0 || colIndex == 0 || rowIndex == colIndex) {
            return 1;
        }
        
        return getNum(rowIndex-1, colIndex-1) + getNum(rowIndex-1, colIndex);
    }

    public static void main(String[] args) throws Exception {

        List<Integer> ans = PascalTriangle.getRow(3);
        ListIterator<Integer> l = ans.listIterator();

        while(l.hasNext()){
            System.out.print(l.next());
        }

    }
}