

import java.util.Scanner;

public class Main {
    static String a, b;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        a = sc.next();
        b = sc.next();

        dp = new int[a.length()][b.length()];

        dp[0][0] = a.charAt(0) == b.charAt(0) ? 0 : 2;

        for (int i = 1; i < a.length(); i++) {
            dp[i][0] = a.charAt(i) == b.charAt(0) ? i : dp[i - 1][0] + 1;
        }
        for (int i = 1; i < b.length(); i++) {
            dp[0][i] = b.charAt(i) == a.charAt(0) ? i : dp[0][i - 1] + 1;
        }

        for (int i = 1; i < a.length(); i++) {
            for (int j = 1; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }

            }
        }

        System.out.println(dp[a.length() - 1][b.length() - 1]);

    }
}
