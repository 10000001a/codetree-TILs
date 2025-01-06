
import java.util.Scanner;

public class Main {
    static Long S;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        S = sc.nextLong();

        int start = (int) Math.floor(Math.sqrt((double) S * 2));

        long sum = start % 2 == 1 ? (long) (start + 1) / 2 * start : (long) (start + 1) * (start / 2);


//        System.out.println("start: " + start);
//        System.out.println("sum: " + sum);

        while (sum > S) {
//            System.out.println("1, " + sum + ", " + S);
            sum -= start;
            start--;
//            System.out.println("start: " + start);
//            System.out.println("sum: " + sum);
        }

        while (S > sum + start + 1) {
//            System.out.println("2, " + (S - sum) + ", " + start);
            start++;
            sum += start;
//            System.out.println("start: " + start);
//            System.out.println("sum: " + sum);
        }

        System.out.println(start);
    }
}
