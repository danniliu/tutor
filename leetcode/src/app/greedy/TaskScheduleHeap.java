package app.greedy;

/**
 * Leetcode: 621. Task Scheduler
 * Reference: https://leetcode.com/problems/task-scheduler/
 * Additional Info: tag: greedy, heap; difficulty: medium 
 * **************************
    Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

    However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

    You need to return the least number of intervals the CPU will take to finish all the given tasks.

    Example:

    Input: tasks = ["A","A","A","B","B","B"], n = 2
    Output: 8
    Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
    

    Constraints:

    The number of tasks is in the range [1, 10000].
    The integer n is in the range [0, 100].

 * ************************** Analysis:
 *  This is implementation using maxHeap (using java PriorityQueue):
 *  Time complexity: O(logN)
 *  Space complexity: O(N)
 */
import java.util.*;

public class TaskScheduleHeap {
    public static int leastInterval(char[] tasks, int n) {
        
        int result = 0;
        
        //For time and space complexity: N = tasks.length
        
        //hashmap to store tasks and their occurence --> time O(1), space O(N)
        Map<Character, Integer> taskMap = new HashMap<>();
        for (Character c: tasks) {
            taskMap.put(c, taskMap.getOrDefault(c, 0) + 1);
        }
        
        //build a max heap based on the map values --> time O(logN), space O(N)
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b)->b-a);
        heap.addAll(taskMap.values());
        
        //process the tasks
        while(!heap.isEmpty()) {
            //use this temp list to memorize the different tasks run in one cycle
            ArrayList<Integer> temp = new ArrayList<>(); 
            
            //pick different tasks to run within n intervals, and record them in the temp list
            //--> time O(1)
            for(int i=0; i<n+1; i++) { 
                if(!heap.isEmpty()) {
                    temp.add(heap.remove());
                }
            }
            
            
            //Add the unfinishing tasks back to the heap
            //--> time O(logN)
            for(int i: temp){
                i--;
                if(i > 0) {
                    heap.add(i);
                }
            }
            
            // sum up the tasks run so far: if no more tasks left in the heap, done; otherwise it is n+1 tasks incuding idle cycles
            result += heap.isEmpty()? temp.size() : n + 1;
            
            
        }
        
        return result;
        
    }
    

    public static void main(String[] args) throws Exception {
        char[] task = {'A', 'A', 'A', 'B', 'B', 'B'};

        int ret = TaskScheduleHeap.leastInterval(task, 2);
        System.out.print(ret);
    }
}