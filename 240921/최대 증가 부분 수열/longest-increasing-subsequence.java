import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] result;
    static int answer;
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N + 1];
        result = new int[N + 1];

        for (int i = 0; i < N; i++) {
            arr[i + 1] = sc.nextInt();
        }

        result[1] = 1;
        answer = 1;
        
        for (int i = 2; i <= N; i++) {
            int tmp = 0;
            for (int j = i - 1; j >= 1; j--) {
                // System.out.println("  " + i + ", " + j);
                if (tmp < result[j] && arr[i] > arr[j]) {
                    // System.out.println("j: " + j + ", result[j]: " + result[j]);
                    tmp = Math.max(tmp, result[j]);
                }
            }
            result[i] = tmp + 1;

            // System.out.println("i: " + i + ", result[i]: " + result[i]);

            answer = Math.max(answer, result[i]);
        }

        System.out.println(answer);
    }
}