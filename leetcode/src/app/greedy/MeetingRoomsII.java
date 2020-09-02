package app.greedy;

import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Leetcode: 253. Meeting Rooms II
 * Reference: https://leetcode.com/problems/meeting-rooms-ii/
 * Additional Info: tag: greedy; difficulty: medium 
 * **************************
    Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

    Example 1:

    Input: [[0, 30],[5, 10],[15, 20]]
    Output: 2
    Example 2:

    Input: [[7,10],[2,4]]
    Output: 1
    NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */

public class MeetingRoomsII {

    public static int minMeetingRooms(int[][] intervals) {
        
        // Check for the base case. If there are no intervals, return 0
        if(intervals.length == 0) {
            return 0;
        }
        
        //min heap
        PriorityQueue<Integer> rooms = new PriorityQueue<>(intervals.length);
        
        // Sort the intervals by start time
        Arrays.sort(intervals,
                    new Comparator<int[]>(){
                       public int compare(final int[] a, final int[] b) {
                           return a[0] - b[0];
                       }
                    }
                   );
        
        // Add the first meeting
        rooms.add(intervals[0][1]);
        
        // Iterate over remaining intervals
        for(int i=1; i<intervals.length; i++){
            
            // If the room due to free up the earliest is free, assign that room to this meeting.
            if(intervals[i][0] >= rooms.peek()) {
                rooms.poll();
            } 
            
            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            rooms.add(intervals[i][1]);
            
        }
        
        // The size of the heap tells us the minimum rooms required for all the meetings.
        return rooms.size();
    }

    public static void main(String[] args) throws Exception {
        int[][] intervals = {
            {0, 30},
            {5, 10},
            {15, 20}
        };

        int rooms = MeetingRoomsII.minMeetingRooms(intervals);
        System.out.print(rooms);
    }
}