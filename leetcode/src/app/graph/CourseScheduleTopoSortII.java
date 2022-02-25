package app.graph;
import java.util.*;
/**
 * this one seems simpler
 */
public class CourseScheduleTopoSortII {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        for (int[] p : prerequisites) {
            indegrees[p[0]]++;
        }
                
        List<List<Integer>> graph = new ArrayList<>(); //build the graph
        for (int i=0 ; i < numCourses; i++) {
            graph.add(new ArrayList<>());            
        }
        
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
        }
                
        Queue<Integer> queue = new LinkedList<>();  //add the course (node) that has no dependency to a queue
        for (int i = 0 ; i < numCourses ; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }            
        
        List<Integer> sort = new ArrayList<>();
        while(!queue.isEmpty()) {
            int n = queue.poll();
            sort.add(n);
            for (int i : graph.get(n)) {
                indegrees[i]--;
                if (indegrees[i] == 0) {
                    queue.offer(i);
                }
            }    
        }
        return sort.size() == numCourses;
    }

    public static void main(String[] args) throws Exception {
        //For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
        int[][] prerequisites = {
                {0, 1},
                {0, 2}
            };
        
        CourseScheduleTopoSortII tSort = new CourseScheduleTopoSortII();
        boolean canfinish = tSort.canFinish(3, prerequisites);
        System.out.println(canfinish);
    }
}
