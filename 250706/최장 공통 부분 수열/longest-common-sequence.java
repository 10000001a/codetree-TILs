import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static String A, B;

    static int[][] dp = new int [1001][1001];


    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        A = sc.next();
        B = sc.next();

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // for (int i = 1; i <= B.length(); i++) {
        //     System.out.println(Arrays.stream(dp[i]).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
        // }

        System.out.println(dp[A.length()][B.length()]);


    }
}