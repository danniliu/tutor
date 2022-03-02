package app.dp;

/**
 * Dynamic Programming
 * https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 * Time Complexity: O(n)
 * Extra Space: O(n) if we consider the function call stack size, otherwise O(1).
 */

public class FibonacciDP {
    public static int fib(int n) {
        if(n<=1) return n;
        int f[] = new int[n+1];
        f[0] = 0;
        f[1] = 1;

        for(int i=2; i<=n; i++){
            f[i] = f[i-1] + f[i-2];
        }

        return f[n];
    }
    public static void main(String[] args) throws Exception {
        System.out.println(fib(9));
    }
}