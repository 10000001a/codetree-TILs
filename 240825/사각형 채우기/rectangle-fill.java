import java.util.*;


// 1    1
// 2    2
// 3    3
// 4    5
// 5    8
// 6    13
// 7    21
// 8    34
public class Main {
    static int N;
    static int[] memo = new int[1001];
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 3;
        memo[4] = 5;
        memo[5] = 8;
        memo[6] = 13;

        System.out.println(fib(N));
    }


    private static int fib(int n) {
        if (memo[n] == 0) {
            memo[n] = (fib(n - 1) + fib(n - 2)) % 10007;
        }

        return memo[n];
    }
}