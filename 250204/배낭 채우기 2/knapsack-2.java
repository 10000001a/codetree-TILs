import java.util.*;

class Diamond {
    int weight;
    int value;

    public Diamond(int w, int v) {
        this.weight = w;
        this.value = v;
    }

    public String toString() {
        return "w: " + this.weight + ", v: " + this.value;
    }
}

public class Main {
    static int N, M;
    static Diamond[] diamonds;
    static int[] dp;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        diamonds = new Diamond[N];
        dp = new int[M + 1];

        for (int i = 0; i < N; i++) {
            diamonds[i] = new Diamond(sc.nextInt(), sc.nextInt());
        }

        // for (Diamond d : diamonds) {
        //     System.out.println(d);
        // }

        for (int i = 1; i <= M; i++) {
            for (Diamond d : diamonds) {
                int idx = i - d.weight;
                if (idx >= 0) {
                    dp[i] = Math.max(dp[i], dp[idx] + d.value);
                }
            }
        }

        // for (int i = 1; i <= M; i++) {
        //     System.out.println(i + ": " + dp[i]);
        // }

        System.out.println(dp[M]);
    }
}