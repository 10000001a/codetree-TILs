import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

            countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> linkedList = new LinkedList<>(countMap.entrySet());

        linkedList.sort(
            new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o2.getValue() == o1.getValue() ? o2.getKey() - o1.getKey() : o2.getValue() - o1.getValue();
                }
            }
        );


        System.out.println(
            linkedList
                .stream()
                .map(i -> Integer.toString(i.getKey()))
                .limit(k)
                .collect(Collectors.joining(" "))
        );


    }
}