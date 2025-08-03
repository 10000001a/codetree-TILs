import java.util.*;

public class Main {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        

        final String S = sc.next();
        final String P = sc.next();



        final int[][] dp = new int[S.length() + 1][P.length() + 1];

        // System.out.println(S.indexOf(0));
        // System.out.println(S.length());
        // System.out.println(P);
        // System.out.println(P.length());

        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= P.length(); j++) {
                // if (j > i) {
                //     dp[i][j] = dp[i][i];
                //     continue;
                // }
                char pattern_char = P.charAt(j - 1);

                switch (pattern_char) {
                    case '.':
                        dp[i][j] = dp[i-1][j-1] + 1;
                        break;
                    case '*':
                        char cmp = P.charAt(j - 2);
                        if (cmp == '.') {
                            dp[i][j] = dp[i - 1][j] + 1;
                        } else if (cmp == S.charAt(i - 1)) {
                            if (dp[i - 1][j] < i - 1 && dp[i][j - 1] < i - 1) {
                                dp[i][j] = dp[i - 1][j];
                            } else {
                                dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i][j - 1]);
                            }
                            
                        } else {
                            dp[i][j] = dp[i][j- 1];
                        }
                        break;
                    default:
                        if (pattern_char == S.charAt(i - 1)) {
                            
                            if (dp[i][j - 1] < i - 1) {
                                dp[i][j] = dp[i - 1][j];
                            } else {
                                dp[i][j] = dp[i - 1][j - 1] + 1;
                            }
                        } else {
                            dp[i][j] = dp[i - 1][j];
                        }
                        break;
                }
            }
        }

        // StringBuilder sb = new StringBuilder();
        // for (int i = 1; i <= S.length(); i++) {
        //     for (int j = 1; j <= P.length(); j++) {
        //         sb.append(dp[i][j]);
        //         sb.append(" ");
        //     }
        //     sb.append("\n");
        // }
        // System.out.println(sb);

        if (dp[S.length()][P.length()] == S.length()) {
            System.out.println("true");
            return;    
        }
        System.out.println("false");

    }
}