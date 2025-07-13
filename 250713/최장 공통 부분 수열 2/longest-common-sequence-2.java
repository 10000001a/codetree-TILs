
import java.util.Scanner;

public class Main {
    static String a, b;

    static int[][] dp;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        a = sc.next();
        b = sc.next();

        dp = new int[a.length() + 1][b.length() + 1];

        if (a.charAt(0) == b.charAt(0)) {
            dp[0][0] = 1;
        }

        for (int j = 1; j < b.length(); j++) {
            if (b.charAt(j) == a.charAt(0)) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i < a.length(); i++) {
            if (b.charAt(0) == a.charAt(i)) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }

        for (int i = 1; i < a.length(); i++) {
            for (int j = 1; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    if (dp[i - 1][j] == dp[i][j - 1]) {
                        dp[i][j] = dp[i][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }


        StringBuilder answer = new StringBuilder();

        int answer_len = dp[a.length() - 1][b.length() - 1];

        int start_x = a.length() - 1;
        int start_y = b.length() - 1;

        for (int z = 0; z < answer_len; z++) {
            boolean break_flag = false;
            for (int i = 0; i <= start_x; i++) {
                for (int j = 0; j <= start_y; j++) {
                    if (dp[i][j] == answer_len - z) {
                        answer.insert(0, a.charAt(i));
                        start_x = i - 1;
                        start_y = j - 1;
                        break_flag = true;
                        break;
                    }
                }

                if (break_flag) {
                    break;
                }
            }
        }
        System.out.println(answer);

    }
}
// 0 0 0 0 1 1
// 1 1 1 1 1 2
// 1 2 2 2 2 2
// 1 2 2 2 3 3
// 1 2 3 3 3 4

// 1 1 1 1
// 1 2 2 2
// 1 2 2 3
