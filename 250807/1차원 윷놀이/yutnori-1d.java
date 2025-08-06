
import java.util.Scanner;

public class Main {
    static int N, M, K;
    static int[] nums;

    static int[] positions;

    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        nums = new int[N];
        positions = new int[K];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        for (int k = 0; k < K; k++) {
            run(0, k);
            positions[k] -= nums[0];
        }

        System.out.println(answer);
    }

    private static void run(int index, int k) {
        positions[k] += nums[index];

//        StringBuilder sb = new StringBuilder();
//        sb.append("index: ");
//        sb.append(index);
//        sb.append(", ");
//        for (int pos : positions) {
//            sb.append(pos);
//            sb.append(' ');
//        }
//        System.out.println(sb);

        if (index == N - 1) {
            int tmp_answer = 0;

            for (int pos : positions) {
//                System.out.println("pos: " + pos);
                if (pos >= M - 1) {
                    tmp_answer++;
                }
            }
            answer = Math.max(tmp_answer, answer);

            return;
        }

        for (int newK = 0; newK < K; newK++) {
//            if (positions[newK] > M) {
//                continue;
//            }
            run(index + 1, newK);
            positions[newK] -= nums[index + 1];
        }
    }
}
