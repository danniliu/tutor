package app.hashtable;

/**
 * Leetcode: 923. 3Sum With Multiplicity
 * Reference: https://leetcode.com/problems/3sum-with-multiplicity/
 * Additional Info: tag: HashTable, Array; difficulty: Medium
 * **************************
    Given an integer array A, and an integer target, return the number of tuples i, j, k  such that i < j < k and A[i] + A[j] + A[k] == target.
    As the answer can be very large, return it modulo 10^9 + 7.

    Example 1:

    Input: A = [1,1,2,2,3,3,4,4,5,5], target = 8
    Output: 20
    Explanation: 
    Enumerating by the values (A[i], A[j], A[k]):
    (1, 2, 5) occurs 8 times;
    (1, 3, 4) occurs 8 times;
    (2, 2, 4) occurs 2 times;
    (2, 3, 3) occurs 2 times.
    Example 2:

    Input: A = [1,1,2,2,2,2], target = 5
    Output: 12
    Explanation: 
    A[i] = 1, A[j] = A[k] = 2 occurs 12 times:
    We choose one 1 from [1,1] in 2 ways,
    and two 2s from [2,2,2,2] in 6 ways.
    
    Note:
    3 <= A.length <= 3000
    0 <= A[i] <= 100
    0 <= target <= 300
 * **************************Analysis:
 * From leetcode article: https://leetcode.com/articles/3sum-with-multiplicity/
 * 1) Adapt from three sum
 * 2) As the answer can be very large, return it modulo 10^9 + 7.   ????
 * 3) use binomial coefficient
 */

public class ThreeSumMulti {
    public static int threeSumMulti(int[] A, int target) {
        int MOD = 1_000_000_007;   // how this MOD is being used?

        // Initializing as long saves us the trouble of
        // managing count[x] * count[y] * count[z] overflowing later.
        long[] count = new long[101];
        int uniq = 0;
        for (int x: A) {
            count[x]++;
            if (count[x] == 1)
                uniq++;
        }

        int[] keys = new int[uniq];
        int t = 0;
        for (int i = 0; i <= 100; ++i)
            if (count[i] > 0)
                keys[t++] = i;

        long ans = 0;
        // Now, let's do a 3sum on "keys", for i <= j <= k.
        // We will use count to add the correct contribution to ans.

        for (int i = 0; i < keys.length; ++i) {
            int x = keys[i];
            int T = target - x;
            int j = i, k = keys.length - 1;  //change j=i to j=i+1???
            while (j <= k) {
                int y = keys[j], z = keys[k];
                if (y + z < T) {
                    j++;
                } else if (y + z > T) {
                    k--;
                } else {  // # x+y+z == T, now calc the size of the contribution
                    if (i < j && j < k) {
                        ans += count[x] * count[y] * count[z];
                    } else if (i == j && j < k) {
                        ans += count[x] * (count[x] - 1) / 2 * count[z];
                    } else if (i < j && j == k) {
                        ans += count[x] * count[y] * (count[y] - 1) / 2;
                    } else {  // i == j == k
                        ans += count[x] * (count[x] - 1) * (count[x] - 2) / 6;
                    }

                    ans %= MOD;
                    j++;
                    k--;
                }
            }
        }

        return (int) ans;
    }

    public static void main(String[] args) throws Exception {
        int[] input  = {1,1,2,2,3,3,4,4,5,5};

        int result = ThreeSumMulti.threeSumMulti(input, 8);
        
        System.out.println(result);
    }
}