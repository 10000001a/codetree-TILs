import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            if (hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num) + 1);
            } else {
                hashMap.put(num, 1);
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();

            System.out.print(hashMap.getOrDefault(num, 0));

            if (i != m - 1) {
                System.out.print(" ");
            }
        }

        // System.out.println(arr.stream().map(Object::toString).collect(joining(" ")));
    }
}