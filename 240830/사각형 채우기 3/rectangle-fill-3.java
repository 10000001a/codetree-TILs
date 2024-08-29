import java.util.*;

public class Main {
    static int N;
    static int[] memo = new int[1001];

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        memo[0] = 1;
        memo[1] = 2;
        memo[2] = 7;
        memo[3] = 22;
        memo[4] = 71;
        memo[5] = 228;

        System.out.println(getResult(N));
    }

    private static int getResult(int n) {
        // System.out.println(n);
        // for (int i = 0; i <= N; i++) {
        //     System.out.println(memo[i]);
        // }
        // System.out.println("");

        if (memo[n] > 0) {

            if (memo[n] >= 1000000007) {
                memo[n] = memo[n] % 1000000007;
            }

            return memo[n];
        }

        long result = 0l;

        result = (long) getResult(n - 1) * 2 + (long) getResult(n - 2) * 3;
        
        for (int i = 0; i < n - 2; i++) {
            result += (getResult(i) * 2);
        }

        memo[n] = (int) (result % 1000000007);
    
        return memo[n];
    }

}

// 0    1
// 1    2       (1 * 2)
// 2    7       (2 * 2) + (1 * 3)
// 3    22      (7 * 2) + (2 * 3) + (1 * 2)
// 4    71      (22 * 2) + (7 * 3) +  (2 * 2) + (1 * 2)
// 5    228     (71 * 2) + (22 * 3) + (7 * 2) + (2 * 2) + (1 * 2)