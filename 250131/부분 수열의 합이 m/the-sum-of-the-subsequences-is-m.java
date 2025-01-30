
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] answer;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        answer = new int[M + 1];

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
//            System.out.println("num: " + num);

            for (int j = M; j >= 1; j--) {
                if (j == num) {
                    answer[j] = 1;
                }

                if (j > num) {
//                    if (answer[j] != 0 && answer[j - num] == 0) {
//                    }

                    if (answer[j] == 0 && answer[j - num] != 0) {
                        answer[j] = answer[j - num] + 1;
                    }

                    if (answer[j] != 0 && answer[j - num] != 0) {
                        answer[j] = Math.min(answer[j], answer[j - num] + 1);
                    }

                }
            }

//            System.out.println(Arrays.stream(answer).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        }


        System.out.println(answer[M] == 0 ? -1 : answer[M]);
    }


}
