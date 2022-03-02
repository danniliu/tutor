package app.ztest;

import java.io.*;
import java.util.*;
/*
Challenge from INRIX Dean, similar to linked list, let's finish it if I have time
*/
class Segment {
    int id;
    int prevId;
    int nextId;
    public Segment(int id, int prevId, int nextId) {
        this.id = id;
        this.prevId = prevId;
        this.nextId = nextId;
    }
}

class Solution {
    public static void main(String[] args) {
        // Add some segments that are in the travel order 9 -> 4 -> 5
        // 4, 5, -1, 9, 4
        Segment[] inputSegments = new Segment[] {
                new Segment(5, 4, -1),
                new Segment(9, -1, 4), 
                new Segment(4, 9, 5)
        };
        Segment[] sortedSegments = SortSegments(inputSegments);
        
        // Verify
    }
    private static Segment[] SortSegments(Segment[] inputSegments) {
        // build adj list and use graph
        // 4, 5, -1, 9, 4, 9, 4, 5
        //order - segment map
        int[] res = new int[inputSegments.length];
        Arrays.fill(res, -1);
       // Map<Integer, Integer> res = new HashMap<>();
        
        for (Segment seg: inputSegments){
            if (seg.prevId == -1) {
               // res[0] = seg.id;
               // res[1] = seg.nextId;
                break;
            }
        }

        int i=0;
        Segment currSeg = inputSegments[i];
        int currPos =  1;
       // while(!currSeg.nextId == -1) {
         //   if (currSeg.id == res[currPos]) {
                
           // }
      //  }
        return null;
    }
}
