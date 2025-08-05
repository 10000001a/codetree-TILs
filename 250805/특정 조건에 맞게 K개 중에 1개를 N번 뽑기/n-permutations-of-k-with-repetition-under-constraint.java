import java.util.Scanner;
import java.util.*;

public class Main {
    static int n, k;
    static int count = 0;
    static int lastNumber = 0;
    final static List<Integer> li  = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        k = sc.nextInt();
        n = sc.nextInt();
        

        for (int i = 1; i <= k; i++) {
            run(i, 1);
        }
    }

    private static void run(int num, int sameCount) {
        li.add(num);

        if (li.size() == n) {
            print();
            li.remove(li.size() -1);
            return;
        }
        

        for (int i = 1; i <= k; i++) {
            int newSameCount = i == num ? sameCount + 1 : 1;

            if (newSameCount == 3) {
                continue;
            }

            run(i, newSameCount);
        }

        li.remove(li.size() -1);
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();



        for (int i: li) {
            sb.append(i);
            sb.append(" ");
        }

        System.out.println(sb);
    }
}