import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n= sc.nextInt();

        double sum = 0.0;

        for (int i = 0; i < n; i++) {
            sum += sc.nextDouble();
        }

        double avg = sum / n;

        System.out.println(Math.round(avg * 10) / 10.0);

        if (avg >= 4) {
            System.out.println("Perfect");
        }

        if (avg < 4 && avg >= 3) {
            System.out.println("Good");
        }

        if (avg < 3) {
            System.out.println("Poor");
        }

        // 여기에 코드를 작성해주세요.
    }
}