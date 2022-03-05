package app.basic.easy;
import java.util.*;
/**
 * 1925. Count Square Sum Triples
 * https://leetcode.com/problems/count-square-sum-triples/
 * ***************
 * A square triple (a,b,c) is a triple where a, b, and c are integers and a2 + b2 = c2.

    Given an integer n, return the number of square triples such that 1 <= a, b, c <= n.

    Example 1:

    Input: n = 5
    Output: 2
    Explanation: The square triples are (3,4,5) and (4,3,5).
    Example 2:

    Input: n = 10
    Output: 4
    Explanation: The square triples are (3,4,5), (4,3,5), (6,8,10), and (8,6,10).
    
    Constraints:

    1 <= n <= 250
 * 
 */
public class CountSquareSumTriples {
    public int countTriples(int n) {
        //build a set to store squares
        Set<Integer> squares = new HashSet<>();
        for (int i=1; i<=n; i++){
          squares.add(i*i);
        }
        
        // do the two loops:
        int count = 0;
        for(int i=1; i<n; i++){
          
          for(int j=i; (i*i+j*j)<=n*n; j++){
            if( squares.contains(i*i + j*j) ){
              count +=2;
            }
          }
          
        }
      
        return count;
          
      }
    
}
