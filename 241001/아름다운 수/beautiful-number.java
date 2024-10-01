import java.util.*;
import java.util.stream.*;

public class Main {
    static int N;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N];

        check(0);

        System.out.println(count);
    }

    private static void check(int index) {
        if (index >= N) {

            count++;
            // print();
            return;
        }
        
        for (int i = 1; i <= Math.min(N, 4); i++) {
            if (index + i <= N){
                for (int j = 0; j < i; j++) {
                    arr[index + j] = i;
                }
                check(index + i);
            }
        }
    }

    // private static void print() {
    //     System.out.println(
    //         Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" "))
    //     ); 
    // }
}