import java.util.*;
import java.util.stream.*;

public class Main {
    static int T;
    static int N;
    static int[][] belt;
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        T = sc.nextInt();

        belt = new int[3][N + 1];

        for (int j = 1; j <= N; j++) {
            belt[1][j] = sc.nextInt();
        }

        for (int j = 1; j <= N; j++) {
            belt[2][j] = sc.nextInt();
        }
        
        for (int a = 0; a < T; a++) {
         

            int tmp = belt[1][N];

            for (int j = N; j >= 2; j--) {
                belt[1][j] = belt[1][j - 1];
            }
            belt[1][1] = belt[2][N];

            for (int j = N; j >= 2; j--) {
                belt[2][j] = belt[2][j - 1];
            }
            belt[2][1] = tmp;
        }


        System.out.println(
            Arrays.stream(Arrays.copyOfRange(belt[1], 1, N + 1))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "))
        );
        System.out.println(
            Arrays.stream(Arrays.copyOfRange(belt[2], 1, N + 1))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "))
        );
    }
}