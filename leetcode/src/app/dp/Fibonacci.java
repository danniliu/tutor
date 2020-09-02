package app.dp;

/**
 * Brute force approach
 * Time Complexity: T(n) = T(n-1) + T(n-2) which is exponential.
 * Extra Space: O(n) if we consider the function call stack size, otherwise O(1).
 */

public class Fibonacci {
    public static int fib(int n) {
        if(n<=1) return n;
        return fib(n-1) + fib(n-2);
    }
    public static void main(String[] args) throws Exception {
        System.out.println(fib(9));
    }
}