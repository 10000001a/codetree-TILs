import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr = sc.next().split(":");

        System.out.println((Integer.parseInt(arr[0]) + 1) + ":" + arr[1]);
        // 여기에 코드를 작성해주세요.
    }
}