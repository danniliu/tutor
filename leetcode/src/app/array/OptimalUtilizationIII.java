package app.array;

/**
 * amazon123: Amazon | OA 2019 | Optimal Utilization
 * Reference: https://leetcode.com/discuss/interview-question/373202
 * Additional Info: tag: array; difficulty: medium 
 * ************************** Description:
    Given 2 lists a and b. Each element is a pair of integers where the first integer represents the unique id and the second integer represents a value. Your task is to find an element from a and an element form b such that the sum of their values is less or equal to target and as close to target as possible. Return a list of ids of selected elements. If no pair is possible, return an empty list.

    Example 1:

    Input:
    a = [[1, 2], [2, 4], [3, 6]]
    b = [[1, 2]]
    target = 7

    Output: [[2, 1]]

    Explanation:
    There are only three combinations [1, 1], [2, 1], and [3, 1], which have a total sum of 4, 6 and 8, respectively.
    Since 6 is the largest sum that does not exceed 7, [2, 1] is the optimal pair.
    Example 2:

    Input:
    a = [[1, 3], [2, 5], [3, 7], [4, 10]]
    b = [[1, 2], [2, 3], [3, 4], [4, 5]]
    target = 10

    Output: [[2, 4], [3, 2]]

    Explanation:
    There are two pairs possible. Element with id = 2 from the list `a` has a value 5, and element with id = 4 from the list `b` also has a value 5.
    Combined, they add up to 10. Similarily, element with id = 3 from `a` has a value 7, and element with id = 2 from `b` has a value 3.
    These also add up to 10. Therefore, the optimal pairs are [2, 4] and [3, 2].
    Example 3:

    Input:
    a = [[1, 8], [2, 7], [3, 14]]
    b = [[1, 5], [2, 10], [3, 14]]
    target = 20

    Output: [[3, 1]]

 * ************************** Analysis:
 * Clarification:
 *  1) if equals, return multiple pairs;
 *  2) if there is no equal, return the closest less value;
 *  3) Otherwise, return the empty list
 * 
 * Throught process:
 *  1) This is Approach 3: brute force, using two D array
 *      loop through a
 *          loop through b
 *              if the sum are matching target, add to a matchingRes list of list
 *              if the sun is less than target, maintain the closest pair in closestRes List
 *              
 *  
 */
import java.util.*;

public class OptimalUtilizationIII {
    public static int ID = 0;
    public static int VALUE = 1;

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



    public static void main(String[] args) throws Exception {
        int[][] list1 = {
            {1,3}, {2,5}, {3,7}, {4,10}
        };
        int[][] list2 = {
            {1,2}, {2,3}, {3,4}, {4,5}
        };
        

        int[][] result = OptimalUtilizationIII.closesPairs(list1, list2, 10);
        for (int[] row: result) {
            System.out.println("  ");
            for (int i: row){
                System.out.print(i + " ");
            }
        }
        /*
        Input:
        List<List<String> a = new ArrayList<>();
        a
        [[1, 3], [2, 5], [3, 7], [4, 10]]
        b = [[1, 2], [2, 3], [3, 4], [4, 5]]
        int target = 10; 

        Output: [[2, 4], [3, 2]]
        */
        
    }
}
