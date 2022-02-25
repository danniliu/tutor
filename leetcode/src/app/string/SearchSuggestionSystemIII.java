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
 * Approach 3: brute force
 * 
 */
import java.util.*;

public class SearchSuggestionSystemIII {

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        //sort use Arrays or Collections?
        
        //sort by arrays
        // brute force
        Arrays.sort(products);
        List<List<String>> res = new ArrayList<>();
                
        for(int i=1; i<=searchWord.length(); i++){
            String sub = searchWord.substring(0, i);
            List<String> match = new ArrayList<>();
            for(String product: products){
                if(product.startsWith(sub)) {
                    match.add(product);
                }
                if(match.size() == 3) {
                    break;
                }
            }
            
            res.add(match);
            
        }
        
        return res;
        
    }



    public static void main(String[] args) throws Exception {
        
        List<List<String>> test  = SearchSuggestionSystemIII.suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse");
        System.out.println(test);
       
    }
}
