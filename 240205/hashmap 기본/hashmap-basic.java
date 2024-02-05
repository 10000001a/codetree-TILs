import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 여기에 코드를 작성해주세요.

        HashMap<Integer, Integer> m = new HashMap<>();
        int cmdCount = sc.nextInt();

        for (int i = 0; i < cmdCount; i++) {
            String cmd = sc.next();

            if (cmd.equals("add")) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                m.put(a, b);
            }

            if (cmd.equals("find")) {
                int a = sc.nextInt();
                int value = m.getOrDefault(a, 0);

                if (value == 0) {
                    System.out.println("None");
                } else {
                    System.out.println(value);
                }
                
            }

            if (cmd.equals("remove")) {
                int a = sc.nextInt();
                m.remove(a);
            }
        }
    }
}