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
        int maxIndexOfLeft = start - 1;
        // int minIndexOfRight = start;

        int pivot = arr[end];

        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                swap(maxIndexOfLeft+ 1, i);
                maxIndexOfLeft++;
                // minIndexOfRight++;
            } else {
                // minIndexOfRight++;
                // swap(maxIndexOfLeft+ 1, i);
                // maxIndexOfLeft++;
            }
        }

        swap(maxIndexOfLeft + 1, end);

        return maxIndexOfLeft + 1;
    }

    // public static int selectPivot(int start, int end) {

    // }

    public static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}