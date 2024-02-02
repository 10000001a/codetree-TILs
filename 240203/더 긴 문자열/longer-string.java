import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();

        if (str1.length() > str2.length()) {
            System.out.print(str1);
            System.out.println(" " + str1.length());
        }

        else if (str1.length() < str2.length()) {
            System.out.print(str2);
            System.out.println(" " + str2.length());
        }
        else {
            System.out.println("same");
        }

        // 여기에 코드를 작성해주세요.
    }
}