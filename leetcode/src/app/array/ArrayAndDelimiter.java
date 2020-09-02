package app.array;

/**
 * Microsoft | L60 | Redmond | February 2020 | Round 3 onSite
 * Reference: https://leetcode.com/discuss/interview-experience/534476/microsoft-l60-redmond-february-2020-offer
 * Additional Info: tag: array; difficulty: easy 
 * **************************
    input:
    char[] arr = {'a', 'b', 'c', '-', 'd', 'e', '/','a', ':', 'b', 'c','*', 'd', 'e'};
    char[] delimiters = {'/', '*', ':', '-'}

    output:
    {"abc", "de", "a", "bc", "de"}

    Interview: 
    1.Implemented with Time Complexity: O(NK) and Space Complexity : O(1) (Excluding Space for Output list)
    2. Optimized to Time Complexity: O(N) and Space Complexity: O(K) (Used HashSet)

    N: Length of arr
    K: Length of delimiters
 */
import java.util.*;
public class ArrayAndDelimiter {

    public static String[] arrayAfterDelimiter(char[] arr, char[] delimiters){
        if(arr == null || arr.length ==0) {
            return null;
        }

        Set<Character> del = new HashSet<>();
        for(char c: delimiters){
            del.add(c);
        }

        List<String> result = new ArrayList<String>();
        StringBuilder b = new StringBuilder();
        for(char c: arr){
            if(!del.contains(c)){
                b.append(c);
            } else {
                result.add(b.toString());
                b = new StringBuilder();
            }
        }

        String[] strResult = new String[result.size()];
        result.toArray(strResult);
        return strResult;

    }

    public static void main(String[] args) throws Exception {
        char[] arr = {'a', 'b', 'c', '-', 'd', 'e', '/','a', ':', 'b', 'c','*', 'd', 'e'};
        char[] delimiters = {'/', '*', ':', '-'};

        String[] result = ArrayAndDelimiter.arrayAfterDelimiter(arr, delimiters);

        for(String s: result) {
            System.out.println(s + " ");
        }
        
    }
}