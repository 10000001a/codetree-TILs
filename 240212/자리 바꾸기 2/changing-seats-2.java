import java.util.*;

class Pair {
    int a, b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
 
}

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int K;
    static List<HashSet<Integer>> seatCount = new ArrayList<HashSet<Integer>>();
    static List<Pair> changeList = new ArrayList<Pair>();
    static List<Integer> seat = new ArrayList<Integer>();

    public static void main(String[] args) {
        N = sc.nextInt();
        K = sc.nextInt();

        for (int i = 0; i < N + 1; i++) {
            seatCount.add(new HashSet<Integer>());
            if (i != 0){
                seatCount.get(i).add(i);
            }
            seat.add(i);
        }

        for (int i = 0; i < K; i++) {
            changeList.add(new Pair(sc.nextInt(), sc.nextInt()));
        }

        for (int i = 0; i < 3; i++) {
            for (Pair p: changeList) {
                int tmp = seat.get(p.a);
                seat.set(p.a, seat.get(p.b));
                seat.set(p.b, tmp);

                seatCount.get(seat.get(p.a)).add(p.a);
                seatCount.get(seat.get(p.b)).add(p.b);
            }
        }
        
        for (int i = 1; i <= N; i++) {
            System.out.println(seatCount.get(i).size());
        }
    }
}