

import java.util.*;

public class Main {


    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();

        final int[][] x = new int[N][3];

        final int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            x[i][0] = sc.nextInt();
            x[i][1] = sc.nextInt();
            x[i][2] = sc.nextInt();
        }

        dp[0][0] = x[0][0];
        dp[0][1] = x[0][1];
        dp[0][2] = x[0][2];


        int l_start = 0, m_start = 1, r_start = 2;

        for (int i = 1; i < N - 1; i++) {
            int new_l, new_m, new_r;

            if (dp[i - 1][1] < dp[i - 1][2]) {
                dp[i][0] = dp[i - 1][2] + x[i][0];
                new_l = r_start;
            } else if (dp[i - 1][1] > dp[i - 1][2]) {
                dp[i][0] = dp[i - 1][1] + x[i][0];
                new_l = m_start;
            } else {
                dp[i][0] = dp[i - 1][1] + x[i][0];
                if (x[N - 1][1] > x[N - 1][2]) {
                    new_l = 2;
                } else {
                    new_l = 1;
                }
            }


            if (dp[i - 1][0] < dp[i - 1][2]) {
                dp[i][1] = dp[i - 1][2] + x[i][1];
                new_m = r_start;
            } else if (dp[i - 1][0] > dp[i - 1][2]) {
                dp[i][1] = dp[i - 1][0] + x[i][1];
                new_m = l_start;
            } else {
                dp[i][1] = dp[i - 1][1] + x[i][1];
                if (x[N - 1][0] > x[N - 1][2]) {
                    new_m = 2;
                } else {
                    new_m = 0;
                }
            }


            if (dp[i - 1][0] < dp[i - 1][1]) {
                dp[i][2] = dp[i - 1][2] + x[i][2];
                new_r = m_start;
            } else if (dp[i - 1][0] > dp[i - 1][1]) {
                dp[i][2] = dp[i - 1][0] + x[i][2];
                new_r = l_start;
            } else {
                dp[i][2] = dp[i - 1][0] + x[i][2];
                if (x[N - 1][0] > x[N - 1][2]) {
                    new_r = 2;
                } else {
                    new_r = 0;
                }
            }

            l_start = new_l;
            m_start = new_m;
            r_start = new_r;
        }


        Set<Integer> s = new HashSet<Integer>() {
            {
                add(1);
                add(2);
            }
        };
        s.remove(l_start);
        dp[N - 1][0] = dp[N - 2][0] + s.stream().mapToInt(i -> x[N - 1][i]).max().orElse(0);

        s = new HashSet<Integer>() {
            {
                add(0);
                add(2);
            }
        };
        s.remove(m_start);
        dp[N - 1][1] = dp[N - 2][1] + s.stream().mapToInt(i -> x[N - 1][i]).max().orElse(0);

        s = new HashSet<Integer>() {
            {
                add(0);
                add(1);
            }
        };
        s.remove(r_start);
        dp[N - 1][2] = dp[N - 2][2] + s.stream().mapToInt(i -> x[N - 1][i]).max().orElse(0);


//        for (int i = 0; i < N; i++) {
//            System.out.println(dp[i][0] + "\t" + dp[i][1] + "\t" + dp[i][2]);
//        }

        System.out.println(Math.max(Math.max(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]));
    }
}
