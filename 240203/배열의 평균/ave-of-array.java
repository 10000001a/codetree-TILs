import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] intArr = new int[2][4];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                intArr[i][j] = sc.nextInt();
            }
        }

        System.out.println(getSum(intArr[0]) + " " + getSum(intArr[1]));

        System.out.println(getSumCol(intArr, 0) + " " + getSumCol(intArr, 1) + " " + getSumCol(intArr, 2)+ " " + getSumCol(intArr, 3));
        System.out.println(getSumTotal(intArr));
        // 여기에 코드를 작성해주세요.
    }

    static double getSum(int[] arr) {
        return Arrays.stream(arr).sum() / 4.0;
    }

    static double getSumCol(int[][] arr, int x) {
        return (arr[0][x] + arr[1][x]) / 2;
    }

    static double getSumTotal(int[][] arr) {
        return (Arrays.stream(arr[0]).sum() + Arrays.stream(arr[1]).sum()) / 8.0;
    }
}