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

        if (wrongIndex == n - 1 ||  arr[wrongIndex - 2] > arr[wrongIndex]) {} else {
            wrongIndex--;
        }

        
        int aIndex = appropriateIndex(arr[wrongIndex]);

        // System.out.println("wrong index: " + wrongIndex + ", aIndex: " + aIndex);

        if (aIndex < wrongIndex) {
            answer = countChange(aIndex, wrongIndex - 1);
        } else {
            answer = countChange(wrongIndex + 1, aIndex);
        }

        
        System.out.println(answer);
    }

    private static int appropriateIndex(int number) {
        for (int i = 0; i < n; i++) {
            if (i == wrongIndex) {
                continue;
            }
            if (arr[i] >= number) {
                return i;
            }
        }
        return -1;
    }

    private static int countChange(int start, int end) {
        int count = 0;
        int before = -1;

        for (int i = start; i <= end; i++) {
            if (arr[i] == arr[wrongIndex]) {
                continue;
            }
   
            if (before != arr[i]) {
                count++;
                before = arr[i];
            }
        }

        return count;
    }
}