
import java.util.*;

public class Main {
    static int N, M;
    static int[] coins;
    static int[] dp;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        coins = new int[N];
        dp = new int[M + 1];

        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }

        for (int i = 1; i <= M; i++) {
            int min = 10001;

            for (int coin : coins) {
                if (i == coin) {
                    min = 1;
                    break;
                }
                if (i - coin <= 0) {
                    continue;
                } else {
                    int n = dp[i - coin] + 1;

                    min = Math.min(min, n);
                }
            }

            dp[i] = min == 10001 ? -1 : min;

//            System.out.println(dp[i]);
        }


        System.out.println(dp[M]);
    }


}
