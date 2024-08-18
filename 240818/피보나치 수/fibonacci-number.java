import java.util.*;

public class Main {
    static int N;
    static final int MAX_N = 45;
    static int[] memo = new int[MAX_N + 1];
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        System.out.println(fib(N));
    }

    private static int fib(int n) {
        if (memo[n] > 0) {
            return memo[n];
        }
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            memo[n] = 1;
            return 1;
        }

        if (n == 2) {
            memo[n] = 1;
            return 1;
        }

        if (n == 3) {
            memo[n] = 2;
            return 2;
        }

        if (n == 4) {
            memo[n] = 3;
            return 3;
        }

        if (n == 5) {
            memo[n] = 5;
            return 5;
        }

        if (n == 6) {
            memo[n] = 8;
            return 8;
        }

        memo[n] = fib(n - 1) + fib(n - 2);

        return memo[n];
    }
}