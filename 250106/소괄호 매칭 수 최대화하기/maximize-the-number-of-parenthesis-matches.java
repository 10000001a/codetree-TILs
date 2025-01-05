

import java.util.*;

class X implements Comparable<X> {
    final int l;
    final int r;
    final int answer;

    X(String s) {
        int l = 0;
        int r = 0;
        int a = 0;


        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            } else {
                r++;
                a += l;
            }
        }

        this.l = l;
        this.r = r;
        this.answer = a;
    }

    @Override
    public int compareTo(X o) {
        return o.l * this.r - this.l * o.r;
    }
}

public class Main {
    static int N;
    static Scanner sc = new Scanner(System.in);
    static X[] inputs;
    static Long restR = 0L;

    public static void main(String[] args) {
        N = sc.nextInt();
        sc.nextLine();

        inputs = new X[N];

        for (int i = 0; i < N; i++) {
            inputs[i] = new X(sc.nextLine());
            restR += inputs[i].r;
        }

        Arrays.sort(inputs);


        System.out.println(calc());
    }

    private static Long calc() {
        long answer = 0L;

        for (int i = 0; i < N; i++) {
            final X target = inputs[i];

            answer += target.answer;
            restR -= target.r;
            answer += target.l * restR;
        }

        return answer;
    }
}
