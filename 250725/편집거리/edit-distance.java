
import java.util.Scanner;

public class Main {
    static String a, b;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        a = sc.next();
        b = sc.next();

        dp = new int[a.length() + 1][b.length()];

        dp[0][0] = a.charAt(0) == b.charAt(0) ? 0 : 1;

        for (int i = 1; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(0)) {
                if (dp[i - 1][0] == i - 1) {
                    dp[i][0] = dp[i - 1][0] + 1;
                } else {
                    dp[i][0] = i;
                }
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
            }

//            System.out.println(dp[i][0]);
        }
//
        for (int j = 1; j < b.length(); j++) {
            if (a.charAt(0) == b.charAt(j)) {
                if (dp[0][j - 1] == j - 1) {
                    dp[0][j] = dp[0][j - 1] + 1;
                } else {
                    dp[0][j] = j;
                }
            } else {
                dp[0][j] = dp[0][j - 1] + 1;
            }

//            System.out.println(dp[0][j]);
        }

        for (int i = 1; i < a.length(); i++) {
            for (int j = 1; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
//                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        System.out.println(dp[a.length() - 1][b.length() - 1]);
    }
}