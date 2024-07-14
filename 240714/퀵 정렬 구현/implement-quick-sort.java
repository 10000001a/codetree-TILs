import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    
        quickSort(0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void quickSort(int start, int end) {
        if (start < end) {
            int indexOfPivot = partition(start, end);

            quickSort(start, indexOfPivot - 1);
            quickSort(indexOfPivot + 1, end);
        }

    }

    public static int selectPivot(int start, int end) {
        final int mid = (start + end) / 2;

        if (arr[start] <= arr[end] && arr[start] <= arr[mid]) {
            return start;
        }

        if (arr[end] <= arr[start] && arr[end] <= arr[mid]) {
            return end;
        }

        return mid;
    }

    public static int partition(int start, int end) {
        int indexOfPivot = selectPivot(start, end);
        int pivot = arr[indexOfPivot];

        swap(indexOfPivot, end);

        int i = start - 1;
        int j = start;

        for (j = start; j < end; j++) {
            if (arr[j] > pivot) {
                
            } else {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, end);

        return i + 1;
    }

    private static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}