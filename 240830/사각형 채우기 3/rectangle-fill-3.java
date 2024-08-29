import java.util.*;

public class Main {
    static int N;
    static int[] memo = new int[1001];

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        memo[0] = 1;
        memo[1] = 2;
        memo[2] = 7;
        memo[3] = 22;
        memo[4] = 71;
        memo[5] = 228;

        System.out.println(getResult(N));
    }

    private static int getResult(int n) {
        if (memo[n] > 0) {
            return memo[n];
        }

        int result = 0;

        for (int i = 1; i <= n; i++) {
            if (i == 2) {
                result += (getResult(n - i) * 3);
            } else if (i == n - 1) {
                result += 2;
            } else {
                result += (getResult(n - i) * 2);
            }
        }

        result += 2;

        memo[n] = result % 1000000007;

        return memo[n];
    }

}

// 0    1
// 1    2       (1 * 2)
// 2    7       (2 * 2) + (1 * 3)
// 3    22      (7 * 2) + (2 * 3) + (1 * 2)
// 4    71      (22 * 2) + (7 * 3) +  (2 * 2) + (1 * 2)
// 5    228     (71 * 2) + (22 * 3) + (7 * 2) + (2 * 2) + (1 * 2)