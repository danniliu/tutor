package app.array;

/**
 * Leetcode: 56. Merge Intervals
 * Reference: https://leetcode.com/problems/merge-intervals/
 * Additional Info: tag: array/sort; difficulty: medium
 * ************************** Description:
    Given a collection of intervals, merge all overlapping intervals.

    Example 1:

    Input: [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
    Example 2:

    Input: [[1,4],[4,5]]
    Output: [[1,5]]
    Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * ************************** Analysis:
 * 1) Approach: sort the interval by their start value, then each set of intervals can be merged will appear as a continuous run in the sorted list
 * 2) Time: O(nlog(n))
 * 3) Space: O(n)
 */
import java.util.*;

public class MergeInterval {
    //Create a comparator that sorts array by their start value
    private class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b){
            return a[0]<b[0] ? -1 : a[0]==b[0] ? 0 : 1;
        }
    }
    public int[][] merge(int[][] intervals) {
        //sort the interval by their start value
        //Time: O(nlog(n))
        //Space: O(1) or O(n) depends on implementation
        Collections.sort(Arrays.asList(intervals), new IntervalComparator());
        
        //each set of intervals can be merged will appear as a continuous run in the sorted list
        //Time: O(n)
        //Space: O(n)
        LinkedList<int[]> merged = new LinkedList<>();
        for(int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if(merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } 
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1],  interval[1]);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
    }
    
    public static void main(String[] args) throws Exception {
        int[][] intervals = {
            {1,2}, {3,5}, {6,7}, {8,10}, {12,16}
        };

        MergeInterval mi = new MergeInterval();

        int[][] result = mi.merge(intervals);

        for(int[] row : result){
            System.out.println("");
            for(int i: row){
                System.out.print(i + " ");
            }
        }
        
    }
}