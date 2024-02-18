import java.util.*;

public class Main {
    static int n, m;
    static TreeSet<Integer> seats;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        seats = new TreeSet<>();

        for (int i = 1; i <= m; i++) {
            seats.add(i);
        }

        for (int i = 0; i < n; i++) {
            Integer target = seats.floor(sc.nextInt());
            // System.out.println(target);

            if (target == null) {
                break;
            }
            
            seats.remove(target);
            answer++;
        }

        System.out.println(answer);
        
    }
}