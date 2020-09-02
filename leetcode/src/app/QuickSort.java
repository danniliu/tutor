package app;

/**
 * Leetcode: 261. Graph Valid Tree
 * Reference: https://leetcode.com/problems/graph-valid-tree/
 * Additional Info: tag: sort; difficulty: medium 
 * ************************** Description:
    This is Quick Sort Implementation from Robert Sedgwick's Algorithms Book:
    Quicksort is a divide-and-conquer method for sorting. It works by partitioning an array into two parts, then sorting the parts independently:
    The crux of the method is the partitioning process, which rearranges the array to make the following three conditions hold:
        * The entry a[j] is in its final place in the array, for some j.
        * No entry in a[lo] through a[j-1] is greater than a[j].
        * No entry in a[j+1] through a[hi] is less than a[j].
    We achieve a complete sort by partitioning, then recursively applying the method to the subarrays. It is a randomized algorithm, because it randomly shuffles the array before sorting it.
 * ************************** Analysis:
 */

public class QuickSort {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }
}