package app;

import java.util.*;

/**
 * Leetcode: 261. Graph Valid Tree
 * Reference: https://leetcode.com/problems/graph-valid-tree/
 * Additional Info: tag: union find/DFS; difficulty: medium 
 * ************************** Description:
    Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

    Example 1:

    Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
    Output: true
    Example 2:

    Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
    Output: false
    Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0,1] is the same as [1,0] and thus will not appear together in edges.
 * ************************** Analysis:
 */

public class App {

    public static String mostCommonWord(String paragraph, String[] banned) {

        Set<String> bannedWords = new HashSet<>();
        for (String word : banned)
            bannedWords.add(word);

        String ans = "";
        int maxCount = 0;
        Map<String, Integer> wordCount = new HashMap<>();
        StringBuilder wordBuffer = new StringBuilder();
        char[] chars = paragraph.toCharArray();

        for (int p = 0; p < chars.length; ++p) {
            char currChar = chars[p];

            // 1). consume the characters in a word
            if (Character.isLetter(currChar)) {
                wordBuffer.append(Character.toLowerCase(currChar));
                if (p != chars.length - 1)
                    // skip the rest of the processing
                    continue;
            }

            // 2). at the end of one word or at the end of paragraph
            if (wordBuffer.length() > 0) {
                String word = wordBuffer.toString();
                // identify the maximum count while updating the wordCount table.
                if (!bannedWords.contains(word)) {
                    int newCount = wordCount.getOrDefault(word, 0) + 1;
                    wordCount.put(word, newCount);
                    if (newCount > maxCount) {
                        ans = word;
                        maxCount = newCount;
                    }
                }
                // reset the buffer for the next word
                wordBuffer = new StringBuilder();
            }
        }
        return ans;
    }



    public static void main(String[] args) throws Exception {
        
        String test  = App.mostCommonWord("Bob. hIt, baLl", new String[]{"bob", "hit"});
        System.out.println(test);
       
    }
}