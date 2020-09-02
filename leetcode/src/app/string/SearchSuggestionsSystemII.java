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
 * Approach 2: straignt forward solution, worst performance, about 27 ms in leetcode submission
 * 
 */
import java.util.*;

public class SearchSuggestionsSystemII {

    public static final int MAX_NUM_PRODUCTS = 3;
    
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        //Init a return value
        List<List<String>> res = new ArrayList<>();
        
        //Sort the array so that prefix return the three lexicographically minimums products
        Arrays.sort(products);  //time: O(NlogN), N is the size of the products array
        
        //Use a string builder to build the prefix
        StringBuilder prefix = new StringBuilder();
        for(int i=0; i<searchWord.length(); i++){
            prefix.append(searchWord.charAt(i));
            res.add(getSuggestedProducts(products, prefix.toString()));
        }
        
        return res;
        
    }
    
    private static List<String> getSuggestedProducts(String[] products, String prefix){
        List<String> res = new ArrayList<>();
        int count = 0;
        int len = products.length;
        int i = 0; 
        //time; worst case N*M (N is the length of product array, M is the length of searchword)
        while(count < MAX_NUM_PRODUCTS && i < len){ 
            if (products[i].startsWith(prefix)) {
                res.add(products[i]);
                count ++;
            }
            i++;
        }
        
        return res;
    }

  public static void main(String[] args) throws Exception {
    String[] products = {"mou","moneypot"};
    String searchWord = "mouse";

    List<List<String>> result = SearchSuggestionsSystemII.suggestedProducts(products, searchWord);
      
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