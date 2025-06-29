import java.util.*;

public class Main {
    static int N;
    static int[] coins;

    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        coins = new int[N+1];
        dp = new int[N + 1][4];

        for (int i = 1; i <= N; i++) {
            coins[i] = sc.nextInt();
        }


        dp[1][1] = coins[1];
        dp[2][0] = coins[2];
        dp[2][2] = coins[1] + coins[2];

        for (int i = 3; i <= N; i++) {
            dp[i][0] = dp[i - 2][0] + coins[i];
            dp[i][1] = (Math.max(dp[i - 1][0], dp[i - 2][1])) + coins[i];
            dp[i][2] = (Math.max(dp[i - 1][1], dp[i - 2][2])) + coins[i];
            dp[i][3] = (Math.max(dp[i - 1][2], dp[i - 2][3])) + coins[i];
        }

        int answer = -1;

        for (int i = 0; i <= 3; i++) {
            answer = Math.max(answer, dp[N][i]);
        }

        System.out.println(answer);
    }
}