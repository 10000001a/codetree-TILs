import java.util.*;

public class Main {
    static int N;
    static int[] prices;
    static int[] dp;
    
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        prices = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            prices[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {

            dp[i] = prices[i];

            for (int j = 1; j <= i / 2; j++) {
                // System.out.println(dp[j] + dp[i - j] + ", " + dp[i]);

                dp[i] = Math.max(dp[j] + dp[i - j], dp[i]);
            }

        }

        System.out.println(dp[N]);
    }
}