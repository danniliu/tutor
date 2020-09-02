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
    Time Complexity: O(AlogA), where A is the length of letter logs, and O(N) for traversal of the array logs
      therefore this one is faster than approach 1.
    Space Complexity: O(N), using auxiliary space 
 */
import java.util.*;

public class ReorderDataInLogFileII {

  public String[] reorderLogFiles(String[] logs) {
        
    //Split logs into letter-logs and digit-logs
    //total space: O(N), N is the length of logs
    List<String> letterLogs = new ArrayList<>(); 
    List<String> digitLogs = new ArrayList<>();
    
    //Loop through the logs array, split each log string to two parts 
    //and use the second part to tell if letter-logs or digit-logs
    //Time : O(N)
    for(String log: logs){
        String[] split = log.split(" ", 2);
        if( Character.isDigit(split[1].charAt(0)) ){
            digitLogs.add(log);
        } else {
            letterLogs.add(log);
        }
    }

    //Sort the letter logs lexicographically: based on the log first then identifier
    //Time: O(AlogA): A is the length of the letter logs
    //Space: O(A), merger sort using auxiliary spaces
    Collections.sort(letterLogs, (log1, log2) -> {
        String[] split1 = log1.split(" ", 2);
        String[] split2 = log2.split(" ", 2);
        int cmp = split1[1].compareTo(split2[1]);
        if (cmp != 0) return cmp;
        return split1[0].compareTo(split2[0]);
    });
    
    //Combine the letter-logs and digit logs using list
    //then List to Array, 4 ms per submission
    //Time: O(N)
    //Space: O(N)
    List<String> res = new ArrayList<>();
    res.addAll(letterLogs);
    res.addAll(digitLogs);
    
    String[] resArray = new String[res.size()];
    resArray = res.toArray(resArray);
    
    return resArray;
    /* Another way to build the result array,
    //Combine the letter-logs and digit logs using array, 13 ms per submission
        int len = logs.length;
        String[] res = new String[len];
        int i = 0;
        Iterator<String> ite;
        //loop through the letter logs
        ite = letterLogs.iterator();
        while (ite.hasNext()) {
            res[i] = ite.next();
            i++;
        }
        //loop through the digit logs
        ite = digitLogs.iterator();
        while(ite.hasNext()){
            res[i] = ite.next();
            i++;
        }
        
        return res; 
    */
    
}

  public static void main(String[] args) throws Exception {
    String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};

    String[] result = ReorderDataInLogFile.reorderLogFiles(logs);

    for(String item: result){
      System.out.print(item + " ");
    }
      
  }
}