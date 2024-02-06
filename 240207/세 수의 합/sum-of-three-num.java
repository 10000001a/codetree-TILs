import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr= new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i == j) {
                    continue;
                }
                for (int a = j + 1; a < n; a++) {
                    if (i == a || j == a) {
                        continue;
                    }

                    if (arr[i] + arr[j] + arr[a] == k) {
                        count++;
                    }
                }
            }
        }
        
        System.out.println(count);
        // 
    }
}