
import java.util.Scanner;

public class Main {
    static String a, b;

    static int[][] dp;
    static int[][][] path;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        a = sc.next();
        b = sc.next();

        dp = new int[a.length() + 1][b.length() + 1];
        path = new int[a.length() + 1][b.length() + 1][2];

        if (a.charAt(0) == b.charAt(0)) {
            dp[0][0] = 1;

        }

        path[0][0][0] = -1;
        path[0][0][1] = -1;

        for (int j = 1; j < b.length(); j++) {
            if (b.charAt(j) == a.charAt(0)) {
                dp[0][j] = 1;
                path[0][j][0] = -1;
                path[0][j][1] = j - 1;

            } else {
                dp[0][j] = dp[0][j - 1];
                path[0][j][0] = 0;
                path[0][j][1] = j - 1;
            }


        }

        for (int i = 1; i < a.length(); i++) {
            if (b.charAt(0) == a.charAt(i)) {
                dp[i][0] = 1;
                path[i][0][0] = i - 1;
                path[i][0][1] = -1;
            } else {
                dp[i][0] = dp[i - 1][0];
                path[i][0][0] = i - 1;
                path[i][0][1] = 0;
            }


        }

        for (int i = 1; i < a.length(); i++) {
            for (int j = 1; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    path[i][j][0] = i - 1;
                    path[i][j][1] = j - 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

                    if (dp[i - 1][j] <= dp[j][j - 1]) {
                        path[i][j][0] = i;
                        path[i][j][1] = j - 1;
                    }

                    if (dp[i - 1][j] > dp[j][j - 1]) {
                        path[i][j][0] = i - 1;
                        path[i][j][1] = j;
                    }
                }
            }
        }
//
//        StringBuilder x = new StringBuilder();
//
//        for (int i = 0; i < a.length(); i++) {
//            for (int j = 0; j < b.length(); j++) {
//                x.append("(").append(path[i][j][0]).append(", ").append(path[i][j][1]).append(") ");
//            }
//            x.append("\n");
//        }

//        System.out.println(x);


        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 && j >= 0) {
            if (path[i][j][0] == i - 1 && path[i][j][1] == j - 1 && a.charAt(i) == b.charAt(j)) {

                sb.append(a.charAt(i));
                i--;
                j--;
            } else {
                int a = path[i][j][0];
                int b = path[i][j][1];

                i = a;
                j = b;
            }

            if (i == -1 && j == -1) {
                break;
            }
//            System.out.println("i: " + i + ", j:" + j);
        }

        System.out.println(sb);
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
//CXFVKGKFCBVXVGGCKKXCXBCVFBKGGFEKBCBFBCCXEBVVEVECGFCFBBBEGGXVVCVEFKGCFVKFCEFVKEEVGKXBGECCFXVVEGKKGEVFEXBGCXKEVXEXVEXKGGVEGCXEGGFGCXXFFXVKVEBVKVBXFXCFKEKEKFKCFBGBFFKBKGBBGCXFBCEVCGFGFGCEKGCGEEEBXXECVVKKBCCGCCFBGBBVFBXVCCBCCGEEXCXGGXBXBFGBGXKXGVVCEBFGVGKFKFCGBVGVEKCFXKEEXCFCGGCBECGKEFVGGGEG
//CXFVKGKFCBVXVGGCKKXCXBCVFBKGGFEBCFBCCXEBVVEVECGFCFBBBEGGXVVCVEFKGCFVKFCEFVKEEVGKXBGECCFXVVEGKKGEVFEXBGCXKEVXEXVEXKGGVEGCXEGGFGCXXFFXVKVEBVKVBXFXCFKEKEKFKCFBGBFFKBKGBBGCXFBCEVCGFGFGCEKGCGEEBXXECVVKKBCCGCCFBGBBVFBXVCCBCCEEXCGGXBXBFGBGXKXGVVCEBFGVGKFKFCGBVGVEKCFXKEEXCFCGGCBECGKEFVGGGEG
