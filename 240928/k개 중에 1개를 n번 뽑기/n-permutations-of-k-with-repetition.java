import java.util.*;
import java.util.stream.*;

public class Main {
    static int N;
    static int K;
    static int[] arr;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        K = sc.nextInt();
        N = sc.nextInt();
        
        arr = new int[N];

        x(0);

    }

    private static void x(int index) {
        if (index == N) {
            print();
            return;
        }

        for (int i = 1; i <= K; i++) {
            arr[index] = i;
            x(index + 1);
        }

    }

    private static void print() {
        System.out.println(
            Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" "))
        );
    }
}