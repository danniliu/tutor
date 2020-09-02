package app.string;

/**
 * Leetcode: 819. Most Common Word
 * Reference: https://leetcode.com/problems/most-common-word/
 * Additional Info: tag: string; difficulty: easy 
 * ************************** Description:
    Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

    Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

    Example:

    Input: 
    paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
    banned = ["hit"]
    Output: "ball"
    Explanation: 
    "hit" occurs 3 times, but it is a banned word.
    "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
    Note that words in the paragraph are not case sensitive,
    that punctuation is ignored (even if adjacent to words, such as "ball,"), 
    and that "hit" isn't the answer even though it occurs more because it is banned.
    
    Note:

    1 <= paragraph.length <= 1000.
    0 <= banned.length <= 100.
    1 <= banned[i].length <= 10.
    The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
    paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
    There are no hyphens or hyphenated words.
    Words only consist of letters, never apostrophes or other punctuation symbols.
 * ************************** Analysis:
 * Approach 1: Intuitive way:
 
  * Time complexity : O(P + B), P is the length of the paragraph, B is the size of the array banned.
  1) HashSet is Implemented using a hash table. Elements are not ordered. The add, remove, and contains methods has constant time complexity O(1). TreeSet is implemented using a tree structure(red-black tree in algorithm book).
  2) Hashmap put and get operation time complexity is O(1) with assumption that key-value pairs are well distributed across the buckets.
    

  * Space complexity :  O(P + B), the banSet set and count hashMap
    
 */
import java.util.*;

public class MostCommonWord {
  public static String mostCommonWord(String paragraph, String[] banned) {
    paragraph += ".";
    
    Set<String> banSet = new HashSet<>();
    for(String w: banned) banSet.add(w);   //time complexity: O(B), B is the size of the array banned
    
    String ans = "";
    int mostC = 0;
    
    Map<String, Integer> count = new HashMap<>();
    StringBuilder word = new StringBuilder();
    char[] chars = paragraph.toCharArray();
    for (char c: chars){  //time complexity: O(P), P is the length of the paragraph
        if (Character.isLetter(c)){
            word.append(Character.toLowerCase(c));
        } else if(word.length() > 0){
            String strWord = word.toString();
            if (banSet.size()==0|| !banSet.contains(strWord)){ //time complexity of hashset contains is O(1) 
                count.put(strWord, count.getOrDefault(strWord, 0)+1);  //time complexity of hashmap put is O(1)  
                if(count.get(strWord) > mostC) { //time complexity of hashmap get is O(1) 
                    ans = strWord;
                    mostC = count.get(strWord);
                }
            }
            word = new StringBuilder();
        }
    }
    
    return ans;
}
    public static void main(String[] args) throws Exception {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        String result = MostCommonWord.mostCommonWord(paragraph, banned);
        System.out.println(result);
    }
}