import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] intArr = new int[4][4];

        for (int i = 0; i < 4; i++) {
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum += sc.nextInt();
            }

            System.out.println(sum);
        }
        // 여기에 코드를 작성해주세요.
    }
}