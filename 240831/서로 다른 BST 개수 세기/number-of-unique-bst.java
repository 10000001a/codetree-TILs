import java.util.*;

public class Main {
    static int N;
    static int[] memo = new int[20];
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();

        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 5;

        System.out.println(getResult(N));

        // for(int i: memo) {
        //     System.out.println(i);
        // }
    }

    private static int getResult(int n) {
        if (memo[n] > 0) {
            return memo[n];
        }

        int result = getResult(n - 1) * 2;

        // System.out.println("result: " + result);
        for (int i = 1; i < n - 1; i++) {
            result += getResult(i) * getResult(n - 1 - i);
            // System.out.println("result: " + result);
        }

        memo[n] = result;


        return result;
    }
}