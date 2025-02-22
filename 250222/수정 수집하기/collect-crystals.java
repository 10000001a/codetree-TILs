
import java.util.Scanner;

enum DIR {
    LEFT,
    RIGHT;

    static DIR of(char v) {
        if (v == 'L') {
            return LEFT;
        }

        return RIGHT;
    }
}

public class Main {
    static int N, K;
    static DIR[] crystal_dir_arr = new DIR[1001];


    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        String input = sc.next();

        int[] dp_l = new int[N + 1];
        int[] dp_r = new int[N + 1];


        for (int i = 0; i < N; i++) {
            crystal_dir_arr[i + 1] = DIR.of(input.charAt(i));
        }

        for (int i = 1; i <= N; i++) {
            if (crystal_dir_arr[i] == DIR.LEFT) {
                dp_l[i] = dp_l[i - 1] + 1;
            } else {
                dp_l[i] = dp_l[i - 1];
            }
        }


        for (int d = 1; d <= K; d++) {
            if (d % 2 == 0) {
                for (int i = 1; i <= N; i++) {
                    if (crystal_dir_arr[i] == DIR.LEFT) {
                        if (crystal_dir_arr[i - 1] == crystal_dir_arr[i]) {
                            dp_l[i] = dp_l[i - 1] + 1;
                        } else {
                            dp_l[i] = Math.max(dp_r[i - 1] + 1, dp_l[i - 1] + 1);
                        }
                    } else {
                        dp_l[i] = Math.max(dp_r[i], dp_l[i - 1]);
                    }


//                    System.out.println(dp_l[i]);
                }
            } else {
                for (int i = 1; i <= N; i++) {

                    if (crystal_dir_arr[i] == DIR.RIGHT) {
                        if (crystal_dir_arr[i - 1] == crystal_dir_arr[i]) {
                            dp_r[i] = dp_r[i - 1] + 1;
                        } else {
                            dp_r[i] = Math.max(dp_l[i - 1] + 1, dp_r[i - 1] + 1);
                        }
                    } else {
                        dp_r[i] = Math.max(dp_l[i], dp_r[i - 1]);
                    }
                }
            }
        }

        final StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(dp_l[i]).append(" ");
        }

        final StringBuilder sb2 = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb2.append(dp_r[i]).append(" ");
        }

//        System.out.println(sb);
//        System.out.println(sb2);

        System.out.println(Math.max(dp_r[N], dp_l[N]));
    }
}
