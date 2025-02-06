import java.util.*;
import java.util.stream.*;

public class Main {
    static int N, M;
    static int[] n_arr, m_arr;

    static int[][] dp, nums;
    static int[] answer;


    public static void main(String[] args) {
        // System.out.println("1234".length());
        final Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();

        n_arr = new int[N + 1];
        m_arr = new int[M + 1];

        dp = new int[N + 1][M + 1];
        nums = new int[N + 1][M + 1];

        answer = new int[1001];


        for (int i = 1; i <= N; i++) {
            n_arr[i] = sc.nextInt();
        }

        for (int i = 1; i <= M; i++) {
            m_arr[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                // System.out.println(n_arr[i] + "  " +  m_arr[j]);
                if (n_arr[i] == m_arr[j]) {
                    // nums[i][j] = m_arr[j];
                    // answer[i][j] = answer[i-1][j-1] + "" + m_arr[j];
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    if (answer[dp[i][j]] == 0) {
                        answer[dp[i][j]] = n_arr[i];
                    } else {
                        answer[dp[i][j]] = Math.min(answer[dp[i][j]], n_arr[i]);

                        // String a = String.valueOf(answer[dp[i][j]]);
                        // String b = String.valueOf(n_arr[i]);

                        // String f = "";

                        // for (int l = 0; l < Math.min(a.length(), b.length()); l++) {
                        //     if (a.indexOf(l) < b.indexOf(l)) {
                        //         f = a;
                        //         break;
                        //     }

                        //     if (a.indexOf(l) > b.indexOf(l)) {
                        //         f = b;
                        //         break;
                        //     }
                        // }

                        // if (f == "") {
                        //     if (a.length() < b.length()) {
                        //         f = a;
                        //     } else{
                        //         f = b;
                        //     }
                        // }
                        
                        // answer[dp[i][j]] = f == a ? answer[dp[i][j]] : n_arr[i];
                    }
                    
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        String a  ="";
        for (int i = 1; i <= dp[N][M]; i++) {
            // System.out.println("i: " + i + ", " + answer[i]);
            if (i == dp[N][M]) {
                a += (answer[i] + "");
            } else {
                a += (answer[i] + " ");
            }
        }

        System.out.println(a);

        // System.out.println(Arrays.stream(answer).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

        // for (int i = 1; i <= N; i++) {
        //     String x = "";
        //     for (int j = 1; j <= M; j++) {
        //         x += (" " + dp[i][j]);
        //     }

        //     System.out.println(x);
        // }

        // System.out.println("\n\n");
        // for (int i = 1; i <= N; i++) {
        //     String x = "";
        //     for (int j = 1; j <= M; j++) {
        //         x += (" " + nums[i][j]);
        //     }

        //     System.out.println(x);
        // }
    }
}