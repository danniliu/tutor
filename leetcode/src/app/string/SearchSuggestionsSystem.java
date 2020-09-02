package app.string;

/**
 * 1268. Search Suggestions System
 * Reference: https://leetcode.com/problems/search-suggestions-system/
 * Additional Info: tag: string; difficulty: medium 
 * ************************** Description:
  Given an array of strings products and a string searchWord. We want to design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with the searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.
  Return list of lists of the suggested products after each character of searchWord is typed. 

  Example 1:

  Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
  Output: [
  ["mobile","moneypot","monitor"],
  ["mobile","moneypot","monitor"],
  ["mouse","mousepad"],
  ["mouse","mousepad"],
  ["mouse","mousepad"]
  ]
  Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
  After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
  After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
  Example 2:

  Input: products = ["havana"], searchWord = "havana"
  Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]

 * ************************** Analysis:
 * Approach 1: Use Sliding Window, good perfomance, time & space in code comment, about 6 to 9 ms in leetcode submission
 * 
 */
import java.util.*;

public class SearchSuggestionsSystem {
  public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
  
    //return value
    List<List<String>> result = new ArrayList<>();
    
    //Sort he products lexicographically 
    Arrays.sort(products); //time: O(NlogN), N is products.length;
    
    int start = 0, end = products.length - 1, min = 0;
    
    //Time: O(MN), M is searchword.length()
    for (int i=0; i<searchWord.length(); i ++){  
        
        //moving the starting point, move forward if the character doesn't match the search word
        //time: O(N)
        while( (start <= end) && 
               (products[start].length() <= i ||  products[start].charAt(i) != searchWord.charAt(i)))
        {
            start ++;
        }
        
        //moving the ending point, move backward if the character doesn't match the search word
        //time: O(N)
        while( (start <= end ) && 
               (products[end].length() <= i || products[end].charAt(i) != searchWord.charAt(i)))
        {
            
            end --;
        }
        
        //Max 3 words, it can only go up to end + 1
        min = Math.min(start+3, end+1);
        
        //build the list and add to the result
        List<String> temp = new ArrayList<>();
        for(int j=start; j<min; j++){
            temp.add(products[j]);
        }
        result.add(temp);
    }
    
    return result;
   
}

  public static void main(String[] args) throws Exception {
    String[] products = {"mou","moneypot"};
    String searchWord = "mouse";

    List<List<String>> result = SearchSuggestionsSystem.suggestedProducts(products, searchWord);
      
    Iterator<List<String>> ite = result.listIterator();
    while(ite.hasNext()){
      List<String> tempList = ite.next();
      Iterator<String> tempIte = tempList.listIterator();
      while(tempIte.hasNext()){
        System.out.print(tempIte.next() + " ");
      }
      System.out.println();
    }
  }
}