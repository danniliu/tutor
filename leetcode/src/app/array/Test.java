package app.array;
import java.util.*;

public class Test {

   

    public static int[][] closesPairs(int[][] firstList, int[][] secondList, int target) {

        
        // use map to mem process result
        int maxVal = -1;
        Map<Integer, List<int[]>> map = new HashMap<>();

        for(int[] firstRow : firstList){

            for(int[] secondRow: secondList){
                int tempSum = firstRow[1] + secondRow[1];
                if (tempSum > target) {
                    continue;
                }
                if(tempSum >= maxVal) {
                    map.putIfAbsent(tempSum, new ArrayList<int[]>());
                    map.get(tempSum).add(new int[]{firstRow[0], secondRow[0]});
                    maxVal = tempSum;
                }
            }
        }
        
        return map.get(maxVal).toArray(new int[map.get(maxVal).size()][2]);

    }

    

    public static void main(String[] args) {
        int[][] list1 = {
            {1,3}, {2,5}, {3,7}, {4,10}
        };
        int[][] list2 = {
            {1,2}, {2,3}, {3,4}, {4,5}
        };
        

        int[][] result = Test.closesPairs(list1, list2, 10);
        for (int[] row: result) {
            System.out.println("  ");
            for (int i: row){
                System.out.print(i + " ");
            }
        }
    }
    
}
