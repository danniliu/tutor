package app.math;

/**
 * Leetcode: 204. Count Primes
 * Reference: https://leetcode.com/problems/count-primes/
 * Additional Info: tag: math; difficulty: easy 
 * ************************** Description:
   Count the number of prime numbers less than a non-negative number, n.

    Example:

    Input: 10
    Output: 4
    Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
    * ************************** Analysis:
    Use Sieve of Erastosthenes algorithms:
    1) The Sieve of Eratosthenes uses an extra O(n) memory and its runtime complexity is O(n log log n). For the more mathematically inclined readers, you can read more about its algorithm complexity on Wikipedia.
    2) Optimization: Loop's ending condition is i * i < n instead of i < sqrt(n) to avoid repeatedly calling an expensive function sqrt(). Reason: 
        Let's write down all of 12's factors:
        2 × 6 = 12
        3 × 4 = 12
        4 × 3 = 12
        6 × 2 = 12
        As you can see, calculations of 4 × 3 and 6 × 2 are not necessary. Therefore, we only need to consider factors up to √n because, if n is divisible by some number p, then n = p × q and since p ≤ q, we could derive that p ≤ √n.
    3) Optimization: start enumerating the multiples of each prime from i*i:
    In fact, we can mark off multiples of 5 starting at 5 × 5 = 25, because 5 × 2 = 10 was already marked off by multiple of 2, similarly 5 × 3 = 15 was already marked off by multiple of 3. Therefore, if the current number is p, we can always mark off multiples of p starting at p2, then in increments of p: p2 + p, p2 + 2p
    4) The Sieve of Eratosthenes uses an extra O(n) memory and its runtime complexity is O(n log log n). For the more mathematically inclined readers, you can read more about its algorithm complexity on Wikipedia: https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes#Algorithm_complexity
*/

public class CountPrimes {
    public int countPrimes(int n) {
        // Initilization
        boolean isPrime[] = new boolean[n];
        for (int i=2; i<n; i++){
            isPrime[i] = true;
        }
        //start to mark off none prime numbers
        // Optimization: Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        for(int i=2; i*i<n; i++){  //First loop is the loop of factors
            if(!isPrime[i]) continue;
            //Optimization: start enumerating the multiples of each prime from i*i.
            for(int j=i*i; j<n; j=j+i){ //Second loop is to mark off the multiples
                isPrime[j] = false;
            }
        }
        
        //count primes
        int count = 0;
        for(int i=2; i<n; i++){
            if(isPrime[i]) count++;
        }
        
        return count;
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }
}