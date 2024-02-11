import java.util.*;

public class Main {
    static int n, m;
    static HashSet<Integer> set1 = new HashSet<>();

    static ArrayList<Integer> arr2 = new ArrayList<>();
    static ArrayList<Integer> answer = new ArrayList<>();
    static HashSet<Integer> set2 = new HashSet<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            set1.add(sc.nextInt());
        }

        m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int a;
            if (set1.contains(sc.nextInt())) {
                a= 1;

            } else {
                a = 0;
            }

            String t = a + "";
            if (i != m -1) {
                t = t + ' ';
            }

            System.out.print(t);
        }




    }
}