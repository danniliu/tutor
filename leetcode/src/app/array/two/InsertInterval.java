package app.array.two;

/**
 * Leetcode: 57. Insert Interval
 * Reference: https://leetcode.com/problems/insert-interval/
 * Additional Info: tag: array/sort; difficulty: medium
 * ************************** Description:
    Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
    You may assume that the intervals were initially sorted according to their start times.

    Example 1:

    Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
    Output: [[1,5],[6,9]]
    Example 2:

    Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    Output: [[1,2],[3,10],[12,16]]
    Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

 * Note:
    -- 2D array init: 
    int[][] arr1 = {
        {1, 2},
        {3, 4}
    }
 * ************************** Analysis:
 */
import java.util.*;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null || intervals.length ==0){
            return new int[][]{newInterval};
        }
        
        List<int[]> result = new ArrayList<>();
        
        int newStart = newInterval[0], newEnd = newInterval[1];
        int i = 0, l = intervals.length;
        
        //Add all intervals before the newInterval
        while(i<l && intervals[i][1]<newStart){
            result.add(intervals[i]);
            i++;
        }
        
        //Merge the newInterval
        while(i<l && intervals[i][0] <= newEnd){
            newStart = Math.min(newStart, intervals[i][0] );
            newEnd = Math.max(newEnd, intervals[i][1] );
            ++i;
        }
         result.add(new int[]{newStart, newEnd});
        
        //Add all the intervals after the new Interval
        while(i<l){
            result.add(intervals[i]);
            i++;
        }
        
        return result.toArray(new int[result.size()][2]);
        
    }
    
    public static void main(String[] args) throws Exception {
        int[][] intervals = {
            {1,2}, {3,5}, {6,7}, {8,10}, {12,16}
        };

        int[] newInterval = {4,8};

        int[][] result = insert(intervals, newInterval);

        for(int[] row : result){
            System.out.println("");
            for(int i: row){
                System.out.print(i + " ");
            }
        }
        
    }
}