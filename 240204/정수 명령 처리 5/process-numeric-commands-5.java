import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> arr = new ArrayList<>();

        int cmdCount = sc.nextInt();

        for (int i = 0; i < cmdCount; i++) {
            String cmd = sc.next();

            if (cmd.equals("push_back")) {
                int num = sc.nextInt();

                push(arr, num);
            }

            if (cmd.equals("get")) {
                int index = sc.nextInt();
                System.out.println(arr.get(index - 1));
            }

            if (cmd.equals("size")) {
                System.out.println(arr.size());
            }

            if (cmd.equals("pop_back")) {
                pop(arr);
            }
        }
    }

    static void push(ArrayList<Integer> arr, int num) {
        arr.add(num);
    }

    static void pop(ArrayList<Integer> arr) {
        arr.remove(arr.size() - 1);
    }
}