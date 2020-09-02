package app.dp;

/**
 * Dynamic Programming, space optimized
 * https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 * Time Complexity: O(n)
 * space: O(1)
 */

public class FibonacciDPII {
    public static int fib(int n) {
        if(n<=1) return n;

        int a=0, b=1, c;

        for(int i=2; i<=n; i++){
            c = a + b;
            a = b;
            b = c;
        }

        return b;
    }
    public static void main(String[] args) throws Exception {
        System.out.println(fib(9));
    }
}