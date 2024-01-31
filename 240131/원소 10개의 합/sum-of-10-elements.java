import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter(" ");

        int sum = 0;

        for (int i = 0; i < 10; i++) {
            sum += sc.nextInt();

        }

        System.out.print(sum);

        // 여기에 코드를 작성해주세요.
    }
}