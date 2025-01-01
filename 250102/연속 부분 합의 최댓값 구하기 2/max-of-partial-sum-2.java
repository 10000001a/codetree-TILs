import java.util.Scanner;

public class Main {
    static int N;
    static int[] nums;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        int answer = -100000001;

        int tmp = 0;

        int a = 0;

        while (a < N) {
            if (tmp == -100000001) {
                tmp = nums[a];
            } else {
                tmp += nums[a];
            }
            a++;

            if (tmp > answer) {
                answer = tmp;
            }


            if (tmp < 0) {
                tmp = -100000001;
            }
        }

        System.out.println(answer);

    }
}