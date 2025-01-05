
import java.util.*;

class X implements Comparable<X> {
    final int l;
    final int r;

    X(int l, int r) {
        this.l = l;
        this.r = r;
    }


    @Override
    public int compareTo(X o) {
        return o.l * this.r - this.l * o.r;
    }
}

public class Main {
    static int N;
    static X[] inputs;
    static Long restR = 0L;
    static Long answer = 0L;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        N = sc.nextInt();


        inputs = new X[N];

        for (int i = 0; i < N; i++) {
            String str = sc.next();

            int l = 0;
            int r = 0;


            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '(') {
                    l++;
                } else {
                    r++;
                    answer += l;
                }
            }


            inputs[i] = new X(l, r);
            restR += inputs[i].r;
        }

        Arrays.sort(inputs);

        calc();
        System.out.println(answer);
    }

    private static void calc() {
        int openSum = 0;

        for (int i = 0; i < N; i++) {
            int closed = inputs[i].r;

            answer += (long) openSum * closed;

            openSum += inputs[i].l;
        }
    }
}