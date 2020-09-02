package app.sort;

/**
 * 937. Reorder Data in Log Files
 * Reference: https://leetcode.com/problems/reorder-data-in-log-files/
 * Additional Info: tag: string, Sort; difficulty: easy 
 * ************************** Description:
  You have an array of logs.  Each log is a space delimited string of words.

  For each log, the first word in each log is an alphanumeric identifier.  Then, either:

  Each word after the identifier will consist only of lowercase letters, or;
  Each word after the identifier will consist only of digits.
  We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

  Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.

  Return the final order of the logs.

  Example 1:

  Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
  Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
  
  Constraints:

  0 <= logs.length <= 100
  3 <= logs[i].length <= 100
  logs[i] is guaranteed to have an identifier, and a word after the identifier.

 * ************************** Analysis:
 * Approach 1: Custom Sort
    Instead of sorting in the default order, we'll sort in a custom order we specify.
    The rules are:
      Letter-logs come before digit-logs;
      Letter-logs are sorted alphanumerically, by content then identifier;
      Digit-logs remain in the same order.
      It is straightforward to translate these ideas into code.

 * Complexity Analysis
    Time Complexity: O(AlogA), where A is the total content of logs.
      time is not very good, 21 ms in leetcode, due to the constant time of running the complex custom sort.
    Space Complexity: O(A), merger sort, using auxiliary space 
 */
import java.util.*;

public class ReorderDataInLogFile {

  public static String[] reorderLogFiles(String[] logs) {
        
    Arrays.sort(logs, (log1, log2) -> {
        String[] split1 = log1.split(" ", 2);
        String[] split2 = log2.split(" ", 2);
        boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
        boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
        //If both are letter log, compare the 2nd part, then 1st part:
        if(!isDigit1 && !isDigit2){
            int cmp = split1[1].compareTo(split2[1]);
            if (cmp != 0) return cmp;
            return split1[0].compareTo(split2[0]);
        }
        
        //If there are digit log and letter log or both digit logs
        return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        
    });
    
    return logs;
  }

  public static void main(String[] args) throws Exception {
    String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};

    String[] result = ReorderDataInLogFile.reorderLogFiles(logs);

    for(String item: result){
      System.out.print(item + " ");
    }
      
  }
}