

import java.util.*;

public class Main {


    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();

        final int[][] x = new int[1001][4];
        final int[][][] dp = new int[1001][4][4];

        for (int i = 1; i <= N; i++) {
            x[i][1] = sc.nextInt();
            x[i][2] = sc.nextInt();
            x[i][3] = sc.nextInt();
        }

        dp[1][1][1] = x[1][1];
        dp[1][2][2] = x[1][2];
        dp[1][3][3] = x[1][3];


        for (int floor = 2; floor <= 1000; floor++) {
            for (int first = 1; first <= 3; first++) {
                for (int dir = 1; dir<= 3; dir++) {
                    for (int cmp = 1; cmp <= 3; cmp++) {
                        if (dir != cmp)
                            dp[floor][first][dir] = Math.max(dp[floor][first][dir], dp[floor-1][first][cmp] + x[floor][dir]);
                    }
                    
                }
            }
        }

        int ans = 0;

        for (int first = 1; first <= 3; first++) {
            for (int dir = 1; dir <= 3; dir++) {
                if (first != dir)
                    ans = Math.max(ans, dp[N][first][dir]); 
            }
        }


        System.out.println(ans);
    }
}
