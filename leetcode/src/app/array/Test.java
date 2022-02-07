package app.array;
import java.util.*;

public class Test {

    public static String[] arrayAfterDelimiter(char[] arr, char[] delimeter) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Set<Character> delSet = new HashSet<>();
        for (char c: delimeter){
            delSet.add(c);
        }
                                
        ArrayList<String> result = new ArrayList<>();
        StringBuilder b = new StringBuilder();
        for (char c: arr){
            if (!delSet.contains(c)){
                b.append(c);
            } else {
                result.add(b.toString());
                b = new StringBuilder();
            }
        }
        if (b.length() > 0 ) {
            result.add(b.toString());
        }

        String[] strResult = new String[result.size()];
        return result.toArray(strResult);
    }

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c', '-', 'd', 'e', '/','a', ':', 'b', 'c','*', 'd', 'e'};
        char[] delimiters = {'/', '*', ':', '-'};

        String[] result = Test.arrayAfterDelimiter(arr, delimiters);
        for (String s: result) {
            System.out.print(s + "  ");
        }
    }
    
}
