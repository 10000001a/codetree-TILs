import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i=0; i<5; i++) {
            for (int j=0; j<3; j++) {
                String a = sc.next();
                String b = sc.next();
                String c = sc.next();

                System.out.println(a.toUpperCase() + " " +b.toUpperCase() + " " + c.toUpperCase() );
            }
        }
        // 여기에 코드를 작성해주세요.
    }
}