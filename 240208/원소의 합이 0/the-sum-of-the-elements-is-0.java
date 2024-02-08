import java.util.*;

public class Main {
    static int n;
    static int ans = 0;
    
    static int[] A;
    static int[] B;
    static int[] C;
    static int[] D;

    static HashMap<Integer, Integer> sumAB = new HashMap<>();
    static HashMap<Integer, Integer> sumCD = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();

            for (int j = 0; j < n; j++) {
                int sum = B[i] + A[j];
                sumAB.put(sum, sumAB.getOrDefault(sum, 0) + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            C[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            D[i] = sc.nextInt();
            
            for (int j = 0; j < n; j++) {
                int sum = D[i] + C[j];
                sumCD.put(sum, sumCD.getOrDefault(sum, 0) + 1);
            }
        }



        for (Map.Entry<Integer, Integer> entry: sumAB.entrySet()) {

            if (sumCD.containsKey(-entry.getKey())) {
                ans += (entry.getValue() * sumCD.get(-entry.getKey()));
            }
        }

        // for (int i = 0; i < sumAB.getKeys().length(); i++) {

        //     if (sumCD.containKey(-sumAB.getKey()[i])) {
        //         ans += sumAB.get(sumAB.getKey()[i]) * sumCD.get(-sumAB.getKey()[i]);
        //     }
        // }

        System.out.println(ans);
    }
}