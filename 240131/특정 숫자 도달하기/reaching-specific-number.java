import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter(" ");

        int sum = 0;
        int count = 0;
        boolean check = false;

        for (int i = 0; i < 10; i++) {
            int n = sc.nextInt();

            if (n >= 250) {
                check = true;
            }

            if (!check) {
                sum += n;
                count ++;
            }
        }
        System.out.print(sum);
        System.out.print(' ');
        System.out.println(Math.round((double)sum / count * 10) / 10.0);

        // System.out.println(sum + ' ' + ((double) sum / count));
        

        
        // 여기에 코드를 작성해주세요.
    }
}