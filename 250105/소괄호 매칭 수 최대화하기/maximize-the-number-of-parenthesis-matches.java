
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
        if (this.l == o.l) {
            return this.r - o.r;
        }
        return o.l - this.l;
    }

    @Override
    public String toString() {
        return "X{" +
                "l=" + l +
                ", r=" + r +
                '}';
    }
}

public class Main {
    static int N;
    static Scanner sc = new Scanner(System.in);
    static X[] inputs;

    public static void main(String[] args) {
        N = sc.nextInt();
        sc.nextLine();

        inputs = new X[N];

        for (int i = 0; i < N; i++) {
            inputs[i] = new X(sc.nextLine());
        }

        Arrays.sort(inputs);

        System.out.println(calc());
    }

    private static int calc() {
        int answer = 0;
        int everyR = Arrays.stream(inputs).mapToInt((obj) -> obj.r).sum();

        for (int i = 0; i < N; i++) {
            final X target = inputs[i];

            answer += target.answer;
            everyR -= target.r;
            answer += target.l * everyR;
        }

        return answer;
    }
}
