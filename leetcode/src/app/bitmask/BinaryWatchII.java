package app.bitmask;

/**
 * Leetcode: 401. Binary Watch
 * Reference: https://leetcode.com/problems/binary-watch/
 * Additional Info: tag: backtracking, bit masking; difficulty: easy 
 * ************************** Description:
    A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

    Each LED represents a zero or one, with the least significant bit on the right.

    For example, the above binary watch reads "3:25".
    Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

    Example:

    Input: n = 1
    Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
    Note:
    The order of output does not matter.
    The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
    The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
 * ************************** Analysis:
 *  Compare with BinaryWatchI, optimised using StringBuilder, and only builde the result when condition is met: runtime reduced from 7ms to 0ms, memory reduced from 38.2 to 38.1
 */
import java.util.*;

public class BinaryWatchII {
    
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        
        if(num<0 || num>8) return result;
        
        StringBuilder time;
        for(int h=0; h<12; h++){
            
            for(int m=0; m<60; m++){
                
                if(Integer.bitCount(h) + Integer.bitCount(m) == num) {
                    time = new StringBuilder("");
                    time.append(Integer.toString(h)).append(":");
                    
                    if (m < 10) {
                          time.append("0").append(Integer.toString(m));
                    } else {
                        time.append(Integer.toString(m));
                    }
                    result.add(time.toString());
                }
                
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

}