import java.util.*;

public class Main {
    static Scanner sc;
    static int N;

    static int[][][] dp = new int[1001][3][3];

    // T의 총 개수
    // 연속된 B의 개수

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        N = sc.nextInt();

        dp[1][0][0] = 1; // G
        dp[1][0][1] = 1; // B
        dp[1][1][0] = 1; // T



        for (int i = 2; i<= N; i++) {
            dp[i][0][0] = (dp[i-1][0][0] + dp[i-1][0][1]) % 1000000007;
            dp[i][0][0] = (dp[i][0][0] + dp[i-1][0][2]) % 1000000007; // GG BG  (BBG)

            dp[i][0][1] = dp[i-1][0][0];                                 // GB
            dp[i][0][2] = dp[i-1][0][1];                                 // (GBB) BB

            
            // dp[i][1][0] = dp[i-1][0][0] + dp[i-1][1][0] + dp[i-1][1][1] + dp[i-1][1][2] + dp[i-1][0][1] + dp[i-1][0][2]; // GT BT (GBT)
            dp[i][1][0] = (dp[i-1][0][0] + dp[i-1][1][0]) % 1000000007;
            dp[i][1][0] = (dp[i][1][0] + dp[i-1][1][1]) % 1000000007;
            dp[i][1][0] = (dp[i][1][0] + dp[i-1][1][2]) % 1000000007;
            dp[i][1][0] = (dp[i][1][0] + dp[i-1][0][1]) % 1000000007;
            dp[i][1][0] = (dp[i][1][0] + dp[i-1][0][2]) % 1000000007;


            dp[i][1][1] = dp[i-1][1][0];                                 // TB
            dp[i][1][2] = dp[i-1][1][1];                                 // (TBB)

            // dp[i][2][0] = dp[i-1][1][0] + dp[i-1][1][1] + dp[i-1][1][2] + dp[i-1][2][0] + dp[i-1][2][1] + dp[i-1][2][2]; // TT, 
            dp[i][2][0] = (dp[i-1][1][0] + dp[i-1][1][1]) % 1000000007;
            dp[i][2][0] = (dp[i][2][0] + dp[i-1][1][2]) % 1000000007;
            dp[i][2][0] = (dp[i][2][0] + dp[i-1][2][0]) % 1000000007;
            dp[i][2][0] = (dp[i][2][0] + dp[i-1][2][1]) % 1000000007;
            dp[i][2][0] = (dp[i][2][0] + dp[i-1][2][2]) % 1000000007;

            dp[i][2][1] = dp[i-1][2][0];
            dp[i][2][2] = dp[i-1][2][1];

            dp[i][0][0] = dp[i][0][0] % 1000000007;
            dp[i][0][1] = dp[i][0][1] % 1000000007;
            dp[i][0][2] = dp[i][0][2] % 1000000007;

            dp[i][1][0] = dp[i][1][0] % 1000000007;
            dp[i][1][1] = dp[i][1][1] % 1000000007;
            dp[i][1][2] = dp[i][1][2] % 1000000007;
            
            dp[i][2][0] = dp[i][2][0] % 1000000007;
            dp[i][2][1] = dp[i][2][1] % 1000000007;
            dp[i][2][2] = dp[i][2][2] % 1000000007;
        }



        // System.out.println(dp[N][0][0]);
        // System.out.println(dp[N][0][1]);
        // System.out.println(dp[N][0][2]);

        // System.out.println(dp[N][1][0]);
        // System.out.println(dp[N][1][1]);
        // System.out.println(dp[N][1][2]);

        // System.out.println(dp[N][2][0]);
        // System.out.println(dp[N][2][1]);
        // System.out.println(dp[N][2][2]);
        int answer = 0;

        answer = (answer + dp[N][0][0]) % 1000000007;
        answer = (answer + dp[N][0][1]) % 1000000007;
        answer = (answer + dp[N][0][2]) % 1000000007;
        answer = (answer + dp[N][1][0]) % 1000000007;
        answer = (answer + dp[N][1][1]) % 1000000007;
        answer = (answer + dp[N][1][2]) % 1000000007;
        answer = (answer + dp[N][2][0]) % 1000000007;
        answer = (answer + dp[N][2][1]) % 1000000007;
        answer = (answer + dp[N][2][2]) % 1000000007;


        System.out.println(answer);
    }
}