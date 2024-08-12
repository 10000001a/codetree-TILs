import java.util.*;

public class Main {
    static final int MAX = 91;
    static int n;
    static int[] arr = new int[MAX];

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < MAX; i++) {
            arr[i] = 0;
        }

        arr[1] = 1;
        arr[2] = 1;

        System.out.println(getNum(n));
    }

    private static int getNum(int index) {
        if (arr[index] == 0) {
            arr[index] = getNum(index - 1) + getNum(index - 2);
            return arr[index];
        }

        return arr[index];
    }
}