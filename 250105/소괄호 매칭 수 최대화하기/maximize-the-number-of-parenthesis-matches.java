import java.util.*;

class X implements Comparable<X> {
    final int l;
    final int r;
    final int answer;

    int getMargin() {
        return this.l - this.r;
    }

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
        if (o.getMargin() == this.getMargin()) {
            if (this.l == o.l) {
                return this.r - o.r;
            }
            return o.l - this.l;
        }
        return o.getMargin() - this.getMargin();
    }
}

public class Main {
    static int N;
    static Scanner sc = new Scanner(System.in);
    static X[] inputs;
    static int restR = 0;

    public static void main(String[] args) {
        N = sc.nextInt();
        sc.nextLine();

        inputs = new X[N];

        for (int i = 0; i < N; i++) {
            inputs[i] = new X(sc.nextLine());
            restR += inputs[i].r;
        }

        Arrays.sort(inputs);

//        for (int i = 0; i < N; i++) {
//            System.out.println(inputs[i]);
//        }

        System.out.println(calc());
    }

    private static int calc() {
        int answer = 0;

        for (int i = 0; i < N; i++) {
            final X target = inputs[i];

            answer += target.answer;
            restR -= target.r;
            if (restR > 0)
                answer += target.l * restR;
        }

        return answer;
    }
}
