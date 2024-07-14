import java.util.*;
public class Main {
    static int n;
    static int[] arr;
    static int wrongIndex;
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();


            if (i > 0 && arr[i] < arr[i - 1]) {
                wrongIndex = i;
            }
        }

        final int wrongNumber = arr[wrongIndex];
        int before = -1;    
        for (int i = wrongIndex - 1; i >= 0; i--) {
            if (arr[i] > wrongNumber) {
                if (arr[i] != before) {
                    answer++;
                    before = arr[i];
                }
            }
        }

        System.out.println(answer);
    }
}