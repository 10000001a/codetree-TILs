import java.util.*;

public class Main {
    static final int MAX = 91;
    static int n;
    static long[] arr = new long[MAX];

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < MAX; i++) {
            arr[i] = 0l;
        }

        arr[1] = 1l;
        arr[2] = 1l;

        System.out.println(getNum(n));
    }

    private static long getNum(int index) {
        if (arr[index] == 0l) {
            arr[index] = getNum(index - 1) + getNum(index - 2);
            return arr[index];
        }

        return arr[index];
    }
}