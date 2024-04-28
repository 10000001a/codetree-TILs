import java.util.Scanner;

public class Main {
    static int sum = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            int num = sc.nextInt();
            if (i == 2 || i == 4 || i == 9) {
                sum += num;
            }
        }

        System.out.println(sum);
    }
}