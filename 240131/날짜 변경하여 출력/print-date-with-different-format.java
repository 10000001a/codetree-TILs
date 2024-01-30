import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\\.");;

        String year = sc.next();
        String month = sc.next();
        String day = sc.next();

        System.out.println(month + "-" + day + "-" + year);
    }
}