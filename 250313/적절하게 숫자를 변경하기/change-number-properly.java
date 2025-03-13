
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] input;
    static int[][][] dp;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        dp = new int[N + 1][M + 1][5];

        input = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            input[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            for (int k = 1; k <= 4; k++) {
                List<Integer> candidate;

                if (k == input[i]) {
                    candidate = Arrays.asList(dp[i - 1][0][k] + 1);
                } else {
                    candidate = Arrays.asList(dp[i - 1][0][k]);
                }

                dp[i][0][k] = candidate.stream().reduce(0, Integer::max);
//                System.out.println("(" + i + ", 0, " + k + "): " + dp[i][0][k]);
            }
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                for (int k = 1; k <= 4; k++) {
                    List<Integer> candidate;
                    if (k == input[i]) {
                        candidate = Arrays.asList(dp[i - 1][j][k] + 1, dp[i - 1][j - 1][1] + 1, dp[i - 1][j - 1][2] + 1, dp[i - 1][j - 1][3] + 1, dp[i - 1][j - 1][4] + 1);
                    } else {
                        candidate = Arrays.asList(dp[i - 1][j][k], dp[i - 1][j - 1][1], dp[i - 1][j - 1][2], dp[i - 1][j - 1][3], dp[i - 1][j - 1][4]);
                    }

                    dp[i][j][k] = candidate.stream().reduce(0, Integer::max);

//                    System.out.println("(" + i + ", " + j + ", " + k + "): " + dp[i][j][k]);
                }
            }
        }


        System.out.println(Arrays.stream(dp[N][M]).reduce(0, Integer::max));
    }
}
