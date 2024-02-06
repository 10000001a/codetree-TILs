import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<String, Integer> countMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String input = sc.next();

            countMap.put(input, countMap.getOrDefault(input, 0) + 1);
        }

        System.out.println(countMap.values().stream().mapToInt(i->i).max().getAsInt());
        // 여기에 코드를 작성해주세요.
    }
}