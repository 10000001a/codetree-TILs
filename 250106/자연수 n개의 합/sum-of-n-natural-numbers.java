
import java.util.Scanner;

public class Main {
    static Long S;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        S = sc.nextLong();

        int start = (int) Math.round(Math.sqrt((double) S * 2));
        long sum = (long) ((float)(1 + start) / 2 * start);

//        System.out.println(start);
//        System.out.println(sum);

        while (sum > S) {
            sum -= start;
            start--;
        }

        while (S - sum > start) {
            start++;
            sum += start;
        }

        System.out.println(start);
    }
}
