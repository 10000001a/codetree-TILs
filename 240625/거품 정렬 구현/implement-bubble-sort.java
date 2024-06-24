import java.util.*;

public class Main {
    static int n;
    static int[] arr = new int[100];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        bubbleSort();

        for(int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.print(arr[i]);
                break;
            } 
            System.out.print(arr[i] + " ");
        }
    }

    public static void bubbleSort() {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}