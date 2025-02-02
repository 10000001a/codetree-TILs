
import java.util.*;
import java.util.stream.Collectors;

class Diamond {
    int weight;
    int value;

    Diamond(int weight, int value) {
        this.weight = weight;
        this.value = value;
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


            for (int j = M; j >= diamonds[i].weight + 1; j--) {
                if (dp[j - diamonds[i].weight] != 0) {
                    dp[j] = Math.max(dp[j] , dp[j - diamonds[i].weight] + diamonds[i].value);
                }
            }

            if (diamonds[i].weight <= M)
                dp[diamonds[i].weight] = Math.max(diamonds[i].value, dp[diamonds[i].weight]);


//            System.out.println(Arrays.stream(dp).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
        }

        int answer = 0;

        for (int i : dp) {
            answer = Math.max(answer, i);
        }

        System.out.println(answer);
    }
}