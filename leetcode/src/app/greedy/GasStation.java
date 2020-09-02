package app.greedy;

/**
 * Leetcode: 134. Gas Station
 * Reference: https://leetcode.com/problems/gas-station/
 * Additional Info: tag: greedy; difficulty: medium 
 * **************************
    There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
    You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

    Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.

    Note:

    If there exists a solution, it is guaranteed to be unique.
    Both input arrays are non-empty and have the same length.
    Each element in the input arrays is a non-negative integer.
    Example 1:

    Input: 
    gas  = [1,2,3,4,5]
    cost = [3,4,5,1,2]

    Output: 3

    Explanation:
    Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
    Travel to station 4. Your tank = 4 - 1 + 5 = 8
    Travel to station 0. Your tank = 8 - 2 + 1 = 7
    Travel to station 1. Your tank = 7 - 3 + 2 = 6
    Travel to station 2. Your tank = 6 - 4 + 3 = 5
    Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
    Therefore, return 3 as the starting index.
 * ************************** Analysis:
 *  This is brute force implementation with sligth optimization:
 *  Time complexity: O(N*N)
 *  Space complexity: O(1)
 */

public class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        
        //exception cases:
        if(len == 0) return 0; //clarification point.
        
        //Brute force search: loop through starting point of 0 to len-1:
        int total; //total gas in the tank
        int curr; //curr location
        for (int i=0; i<len; i++){  //i is starting point
            //optimization 1: It's impossible to start at a station i if gas[i]<cost[i], run time 70ms -> 50ms
            if(gas[i] < cost[i]) continue; 
            total = 0;
            curr = i;
            do {
                total = total + gas[curr]-cost[curr]; //total gas when you arrive next gas station
                curr = (curr <= len-2)? curr+1 : 0;
            } while(curr != i && total >= 0);
                
            if(total>=0) return i;
        }
        
        return -1;
        
    }

    public static void main(String[] args) throws Exception {
        int[] gas = {5,1,2,3,4};
        int[] cost = {4,4,1,5,1};
        

        int ret = GasStation.canCompleteCircuit(gas, cost);
        System.out.print(ret);
    }
}