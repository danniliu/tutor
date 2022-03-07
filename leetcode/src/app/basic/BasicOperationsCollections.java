package app.basic;
import java.util.*;

public class BasicOperationsCollections {
    public static void  main (String[] args){
        //arrays
        int[] dp = new int[5];
        Arrays.fill(dp, 5);
        

        // List: LinkedList implemented Queue interface, also has getFirst(), getLast(), which are not in ArrayList
        // Arrays to List
        String a[] = new String[]{"a", "b"};
        Arrays.sort(a);
        List<String> list1 = Arrays.asList(a);

        // List to array
        List<String> itemList = new ArrayList<String>();
        itemList.add("item1");
        String[] itemsArray = new String[itemList.size()];
        itemsArray = itemList.toArray(itemsArray);

        //List init: https://www.geeksforgeeks.org/initialize-an-arraylist-in-java/
    }
}
