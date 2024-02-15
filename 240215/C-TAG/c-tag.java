import java.util.*;

public class Main {
    static int n, m;
    static String[] groupA, groupB;
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        groupA = new String[n];
        groupB = new String[n];


        for (int j = 0; j < n; j++) {
            groupA[j] = sc.next();

        }

        for (int j = 0; j < n; j++) {
            groupB[j] = sc.next();
        }

        for (int i = 0; i < m - 2; i++) {
            for (int j = i + 1; j < m - 1; j++) {
                for (int k = j + 1; k < m; k++) {
                    HashSet<String> idStr = new HashSet<String>();
                    HashSet<String> idStr2 = new HashSet<String>();

                    for (int l = 0; l < n; l++) {
                        idStr.add("" + groupA[l].charAt(i) + groupA[l].charAt(j) + groupA[l].charAt(k));
                        idStr2.add("" + groupB[l].charAt(i) + groupB[l].charAt(j) + groupB[l].charAt(k));
                    }
                    
                    Set<String> x = new HashSet<>(idStr);
                    x.retainAll(idStr2);
                    if (x.isEmpty()) {
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}