package app.greedy;

/**
 * Leetcode: 763. Partition Labels
 * Reference: https://leetcode.com/problems/partition-labels/
 * Additional Info: tag: greedy, two pointer; difficulty: medium 
 * **************************
    A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

    Example 1:

    Input: S = "ababcbacadefegdehijhklij"
    Output: [9,7,8]
    Explanation:
    The partition is "ababcbaca", "defegde", "hijhklij".
    This is a partition so that each letter appears in at most one part.
    A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
    
    Note:

    S will have length in range [1, 500].
    S will consist of lowercase English letters ('a' to 'z') only.

 * ************************** Analysis:
 *  
 */
import java.util.*;

public class PartitionLabel {

    public static List<Integer> partitionLabels(String S) {
        
        //build the array of the 26 characters with the last appearance
        //of the character within the string S
        //space: O(1)
        //time: O(N, N is the length of the string S
        int[] last = new int[26];
        int len = S.length();
        for(int i=0; i<len; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        
        
        //starting and ending pointers while a partition is identified
        //space: O(A), A is the number of partitions
        //time: O(N), N is the length of the string S
        int start = 0, end = 0;
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<len; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (end == i) {  //a partition is identified
                res.add(end - start + 1);
                start = end + 1; //reset the start pointer
            }  
            
        }
        
        return res;  
    }

    public static void main(String[] args) throws Exception {
        String label = "ababcbacadefegdehijhklij";
        
        List<Integer> ret = PartitionLabel.partitionLabels(label);
        for(int i=0; i<ret.size(); i++){
            System.out.print(ret.get(i) + "  ");
        }
    }
}