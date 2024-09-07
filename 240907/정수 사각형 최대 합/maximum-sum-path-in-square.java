import java.util.*;
import java.util.stream.*;

public class Main {
    static int N;
    static int[][] matrix;
    static int[][] memo;
    static final Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        N = sc.nextInt();
        matrix = new int[N + 1][N + 1];
        memo = new int[N + 1][N + 1];

        initializeMatrix();
        initializeMemo();

        // printMemo();

        System.out.println(memo[N][N]);
    }

    private static void initializeMatrix() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }

    private static void initializeMemo() {
        for (int i = 1; i <= N; i++) {
            memo[1][i] = memo[1][i - 1] + matrix[1][i];
            memo[i][1] = memo[i - 1][1] + matrix[i][1];
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= N; j++) {
                memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]) + matrix[i][j];
            }
        }
    }

    private static void printMatrix() {
        for (int i = 0; i <= N; i++) {
            System.out.println(
                Arrays.stream(matrix[i]).mapToObj(String::valueOf).collect(Collectors.joining(" "))
            );
        }
    }

    private static void printMemo() {
        for (int i = 0; i <= N; i++) {
            System.out.println(
                Arrays.stream(memo[i]).mapToObj(String::valueOf).collect(Collectors.joining(" "))
            );
        }
    }
}