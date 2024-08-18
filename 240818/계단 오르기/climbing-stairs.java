import java.util.*;

public class Main {
    static int N;
    static int[] memo = new int[1001];

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        System.out.println(calc(N));
    }

    private static int calc(int n) {
        if (memo[n] > 0) {
            return memo[n];
        }

        if (n == 2) {
            memo[2] = 1;
            return 1;
        }

        if (n == 3) {
            memo[3] = 1;
            return 1;
        }

        if (n == 4) {
            memo[4] = 1;
            return 1;
        }

        memo[n] = (calc(n - 2) + calc(n - 3)) % 10007;

        return memo[n];
    }
}

// 2 3 4 5 6 7
// 1 1 1 2 2