package app.dp;

/**
 * TODO: DP to do fibonacci number and factorial
 */

public class ATest {
    public static int fib(int n) {
        if(n<=1) return n;
        return fib(n-1) + fib(n-2);
    }
    public static void main(String[] args) throws Exception {
        System.out.println(fib(9));
    }
}