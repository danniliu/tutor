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
 *  1) This is Approach 1: brute force
 *      loop through a
 *          loop through b
 *              if the sum are matching target, add to a matchingRes list of list
 *              if the sun is less than target, maintain the closest pair in closestRes List
 *              
 *  
 */
import java.util.*;

public class OptimalUtilization {
    public static int ID = 0;
    public static int VALUE = 1;

    public static List<List<Integer>> closestPairs(List<List<Integer>> a, List<List<Integer>> b, int target){
        
        int maxVal = -1; //mem the closest sum of values for the pair
        //sum to the list of pairs map to mem the sums that are close to the target
        Map<Integer, List<List<Integer>>> map = new HashMap<>(); 

        //loop through list a and b
        int aSize = a.size();
        int bSize = b.size();
        if(aSize == 0 || bSize ==0) return new ArrayList<List<Integer>>();

        for(int i=0; i<aSize; i++){   //time: O(M*N), M is size of a, N is size of b
            List<Integer> aItem = a.get(i);
            for(int j=0; j<bSize; j++){
                List<Integer> bItem = b.get(j);
                int tempSum = aItem.get(VALUE) + bItem.get(VALUE);
                if(tempSum > target) continue;
                if(tempSum >= maxVal){
                    map.putIfAbsent(tempSum, new ArrayList<>());
                    List<Integer> list = new ArrayList<>();
                    list.add(aItem.get(ID));
                    list.add(bItem.get(ID));
                    map.get(tempSum).add(list);
                    maxVal = tempSum;
                }

            }
        }

        return map.get(maxVal);
    }



    public static void main(String[] args) throws Exception {
        List<List<Integer>> a = new ArrayList<>();
        a.add(Arrays.asList(1, 3));
        a.add(Arrays.asList(2, 5));
        a.add(Arrays.asList(3, 7));
        a.add(Arrays.asList(4, 10));

        List<List<Integer>> b = new ArrayList<>();
        b.add(Arrays.asList(1, 2));
        b.add(Arrays.asList(2, 3));
        b.add(Arrays.asList(3, 4));
        b.add(Arrays.asList(4, 5));

        int target = 10;

        List<List<Integer>> res = OptimalUtilization.closestPairs(a, b, target);
        Iterator<List<Integer>> iteL = res.iterator();
        while(iteL.hasNext()){
            List<Integer> item = iteL.next();
            System.out.println(item.get(0) + " " + item.get(1));
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