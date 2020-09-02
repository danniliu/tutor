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
 * This is Approach 2: use two pointers, better performance than brute force:
 * Time: Since the sorting part complexity is O(MlogM + NlogN) and two-pointer traversal is O(M + N), the final complexity can be regarded as O(KlogK) where K is the longest input array.
 * Space: worst case, O(m * n)     
 *              
 *  
 */
import java.util.*;

public class OptimalUtilizationII {
    public static int ID = 0;
    public static int VALUE = 1;

    public static List<List<Integer>> closestPairs(List<int[]> a, List<int[]> b, int target){
        List<List<Integer>> res = new ArrayList<>();

        int m = a.size();
        int n = b.size();
        if(m == 0 || n == 0) return res;

        //Sort list a and b:
        Collections.sort(a, (item1, item2) -> (item1[1] - item2[1])); //time: O(mlogm), m is a.size()
        Collections.sort(b, (item1, item2) -> (item1[1] - item2[1])); //time: O(nlogn), n is b.size()
        
        //set up pointers:
        int left = 0;  //memorize the pointer for List a starts from left
        int right = n-1;  //memorize the pointer for List b starts from right
        int maxVal = -1; //mem the val that is less or equal to target and as close to target as possible

        Map<Integer, List<List<Integer>>> map = new HashMap<>(); //map to mem the closest values

        //Time: two pointer traversal is O(m + n)
        while(left < m && right >= 0){
            int sum = a.get(left)[1] + b.get(right)[1];
            if(sum > target) {
                right --; 
                continue;
            } else {
                if (sum >= maxVal){
                    map.putIfAbsent(sum, new ArrayList<>());
                    // Check for duplicates in list b
                    int r = right;
                    while(r >= 0 && (b.get(right)[1]==b.get(r)[1])){
                        List<Integer> list = new ArrayList<>();
                        list.add(a.get(left)[0]);
                        list.add(b.get(r)[0]);
                        map.get(sum).add(list);
                        r--;
                    }
                    maxVal = sum;
                }
                left ++;
            }
        }

        return map.get(maxVal);
    }



    public static void main(String[] args) throws Exception {
        List<int[]> a = new ArrayList<>();
        a.add(new int[]{1, 3});
        a.add(new int[]{2, 5});
        a.add(new int[]{3, 7});
        a.add(new int[]{4, 10});

        List<int[]> b = new ArrayList<>();
        b.add(new int[]{1, 2});
        b.add(new int[]{2, 3});
        b.add(new int[]{3, 4});
        b.add(new int[]{4, 5});

        int target = 10;

        List<List<Integer>> res = OptimalUtilizationII.closestPairs(a, b, target);
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