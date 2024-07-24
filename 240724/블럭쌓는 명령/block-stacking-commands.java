import java.util.*;

public class Main {
    static int N, K;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = 0;
        }

        for (int i = 0; i < K; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            for (int j = a; j <= b; j++) {
                arr[j]++;
            }
        }

        // printArr();

        quickSort(0, N - 1);
        
        // printArr();

        System.out.print(arr[N / 2]);

    }

    public static void printArr() {
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int start, int end) {
        if (start >= end) {
            return;
        }

        // System.out.println("start: " + start + ", end: " + end);
        // printArr();
        // System.out.println("");

        int idx = partition(start, end);

        // System.out.println("index: " + idx);
        // System.out.println("");

        quickSort(start, idx - 1);
        quickSort(idx + 1, end);
    }

    public static int partition(int start, int end) {

        int lowIndex = start - 1;

        int pivot = selectPivot(start, end);

        for (int i = start; i <= end; i++) {
            if (arr[i] <= arr[pivot]) {
                lowIndex++;
                swap(lowIndex, i);
            }
        }

        swap(lowIndex, pivot);

        return lowIndex;
    }

    public static int selectPivot(int i, int j) {
        final int mid = (i + j) / 2;
        
        if (arr[i] >= arr[mid] && arr[mid] >= arr[j]) {
            return mid;
        }

        if (arr[i] <= arr[mid] && arr[mid] <= arr[j]) {
            return mid;
        }

        if (arr[mid] >= arr[i] && arr[i] >= arr[j]) {
            return i;
        }

        if (arr[mid] <= arr[i] && arr[i] <= arr[j]) {
            return i;
        }

        return j;
    }

    public static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}