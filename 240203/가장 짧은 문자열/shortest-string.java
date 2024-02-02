import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();
        String str3 = sc.next();

        int min = 21;
        int max = 0;

        if (str1.length() > max) {
            max = str1.length();
        }

         if (str2.length() > max) {
            max = str2.length();
        }


 if (str3.length() > max) {
            max = str3.length();
        }


 if (str1.length() < min) {
            min = str1.length();
        }


 if (str2.length() < min) {
            min = str2.length();
        }
 if (str2.length() < min) {
            min = str2.length();
        }
        // 여기에 코드를 작성해주세요.

        System.out.println(max - min);
    }
}