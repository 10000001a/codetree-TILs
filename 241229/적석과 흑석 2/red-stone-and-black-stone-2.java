
import java.util.*;

class BlackStone implements Comparable<BlackStone> {
    final int a, b;

    BlackStone(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(BlackStone o) {
        if (this.b == o.b) {
            return this.a - o.a;
        }

        return this.b - o.b;
    }
}

public class Main {
    static int C, N;
    static TreeSet<Integer> redStones = new TreeSet<>();
    static BlackStone[] blackStones;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        C = sc.nextInt();
        N = sc.nextInt();


        blackStones = new BlackStone[N];


        for (int i = 0; i < C; i++) {
            redStones.add(sc.nextInt());
        }

        for (int i = 0; i < N; i++) {
            blackStones[i] = new BlackStone(sc.nextInt(), sc.nextInt());
        }

        sortBlackStones();

        int answer = getAnswer();

        System.out.println(answer);

    }

    private static int getAnswer() {
        int answer = 0;

        for (int i = 0; i < N; i++) {
            int a = blackStones[i].a;
            int b = blackStones[i].b;

            Integer c = redStones.ceiling(a);

            if (c != null) {
                if (c <= b) {
                    redStones.remove(c);
                    answer++;
                }
            }
        }

        return answer;
    }

    private static void sortBlackStones() {
        List<BlackStone> list = new ArrayList<>();
        for (BlackStone blackStone : blackStones) {
            list.add(blackStone);
        }
        List<BlackStone> blackStoneList = new ArrayList<>(list);
        Collections.sort(blackStoneList);

        for (int i = 0; i < N; i++) {
            blackStones[i] = blackStoneList.get(i);
//            System.out.println(blackStones[i]);
        }
    }
}
