package app.string.largeNumber;
import java.util.*;

/**
 * 179. Largest Number
 * Reference: https://leetcode.com/problems/largest-number/
 * Additional Info: tag: string; difficulty: medium 
 * ************************** Description:
    Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

    Since the result may be very large, so you need to return a string instead of an integer.

    Example 1:

    Input: nums = [10,2]
    Output: "210"
    Example 2:

    Input: nums = [3,30,34,5,9]
    Output: "9534330"

    Constraints:

    1 <= nums.length <= 100
    0 <= nums[i] <= 109
---------------------- analysis:
    Time: O(nlgn)
    Space: O(n)
 */

public class LargeNumberI {
    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
           return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {
        // Get input integers as strings.
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Sort strings according to custom comparator.
        Arrays.sort(asStrs, new LargerNumberComparator());

        // If, after being sorted, the largest number is `0`, the entire number
        // is zero.
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // Build largest number from sorted array.
        String largestNumberStr = new String();
        for (String numAsStr : asStrs) {
            largestNumberStr += numAsStr;
        }

        return largestNumberStr;
    }

    public static void main(String[] args) {
        int[] test = {10,2};
        LargeNumberI solution = new LargeNumberI();
        String res = solution.largestNumber(test);
        
    }
    
}
