import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int n;
    static int[] arr = new int[100000];

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        mergeSort(0, n - 1);


        printAnswer();

    }

    private static void mergeSort(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            merge(start, end);
        }
    }

    private static void merge(int start, int end) {
        int i = start;
        int j = (start + end) / 2 + 1;
        
        List<Integer> tmpList = new ArrayList<>();

        while (i <= (start + end) / 2 || j <= end) {        
            if (i > (start + end) / 2) {
                tmpList.add(arr[j]);
                j++;
                continue;
            }

            if (j > end) {
                tmpList.add(arr[i]);
                i++;
                continue;
            }

            if (arr[i] <= arr[j]) {
                tmpList.add(arr[i]);
                i++;
            } else {
                tmpList.add(arr[j]);
                j++;
            }
        }

        int index = start;
        for (Integer a: tmpList) {
            arr[index] = a;
            index++;
        }
    }

    private static void printAnswer() {
        final String answer = Arrays.stream(
            Arrays.copyOfRange(arr, 0, n)
        )
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(" "));

        System.out.println(answer);
    }
}