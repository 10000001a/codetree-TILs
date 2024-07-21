import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = n / 2; i > 0; i--) {
            heapify(i, n);
        }

        // print();

        heapSort();

        print();
    }

    public static void heapSort() {
        for (int i = 0; i < n; i++) {
            // System.out.println("i: "+i);
            swap(1, n - i);
            
            // print();
            heapify(1, n - i - 1);
            // print();

            // System.out.println("");
        }
    }

    public static void heapify(int index, int range) {
        if (index > range / 2) {
            return;
        }

        final int a = arr[index];
        final int b = arr[index * 2];
        final int c = index * 2 + 1 > range ? -1 : arr[index * 2 + 1];

        if (b > a) {
            if (b > c) {
                swap(index, index * 2);
                heapify(index * 2, range);
            } else {
                swap(index, index * 2 + 1);
                heapify(index * 2 + 1, range);
            }
        } else if (c > a) {
            swap(index, index * 2 + 1);
            heapify(index * 2 + 1, range);
        }
    }

    public static void swap(int a, int b) {
        final int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    
    public static void print() {
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
}