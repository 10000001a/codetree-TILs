import java.util.*;
import java.util.stream.*;

public class Main {
    static int N, M;
    static int[][] table;
    static int[][] dp;
    static int answer = 0;
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        table = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                table[i][j] = sc.nextInt();
            }
        }

        init();

        for (int i = 4; i < (N + M + 1); i++){
            if (i - 2 > N) {
                for (int j = (i - N); j <= Math.min(i - 2, M); j++) {
                    // System.out.println("-i: " + (i - j) + ", j: " + j);
                    // if (i - j > 1)
                    setDP(i - j, j);
                }
            } else {
                for (int j = 2; j <= Math.min(i - 2, M); j++) {
                    // System.out.println("i: " + (i - j) + ", j: " + j);
                    setDP(i - j, j);
                }
            }
        }

        // printDP();
        printAnswer();
    }

    private static void init() {
        dp[1][1] = 1;
        // for (int i = 2; i <= N; i++) {
        //     dp[i][1] = -10;
        // }

        // for (int i = 2; i <= M; i++) {
        //     dp[1][i] = -10;
        // }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = -10;
            }
        }

        dp[1][1] = 1;
    }

    private static void setDP(int x, int y) {
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                if (table[i][j] < table[x][y]) {
                    dp[x][y] = Math.max(dp[i][j] + 1, dp[x][y]);
                    
                }
            }
        }
    }

    private static void printTable() {
        for (int i = 1; i <= N; i++) {
            System.out.println(
                Arrays.stream(table[i])
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining("  "))
            );
        }
    }

    private static void printDP() {
        for (int i = 1; i <= N; i++) {
            System.out.println(
                Arrays.stream(dp[i])
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining("  "))
            );
        }
    }

    private static void printAnswer() {
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (dp[i][j] > answer) {
                    answer = dp[i][j];
                }
            }
        }
        System.out.println(answer);
    }
}