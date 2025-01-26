
import java.util.*;

class Line implements Comparable<Line> {
    int line1;
    int line2;
    int pos;
    Set<Integer> owner = new HashSet<>();

    public Line(int line1, int pos) {
        this.line1 = line1;
        this.line2 = line1 + 1;
        this.pos = pos;
    }

    public void setOwner(int i) {
        this.owner.add(i);
    }

    public boolean hasOwner(int i) {
        return this.owner.contains(i);
    }

    @Override
    public int compareTo(Line o) {
        return this.pos - o.pos;
    }

    @Override
    public String toString() {
        return "Line{" +
                "line1=" + line1 +
                ", line2=" + line2 +
                ", pos=" + pos +
                ", owner=" + owner +
                '}';
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N, M;
    static Line[] lines;

    public static void main(String[] args) {
        N = sc.nextInt();
        M = sc.nextInt();

        lines = new Line[M];

        for (int i = 0; i < M; i++) {
            lines[i] = new Line(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(lines);

        for (int n = 1; n <= N; n++) {
            runGame(n);
        }

//        printLines();

        System.out.println(M - c());


    }

    private static void printLines() {
        for (int i = 0; i < M; i++) {
            System.out.println(lines[i]);
        }
    }

    private static void runGame(int n) {
        int currentN = n;
        Optional<Line> line = findLine(currentN, 0);

        while (line.isPresent()) {
            Line currentLine = line.get();
            currentLine.setOwner(n);

            if (currentLine.line1 != currentN) {
                currentN = currentLine.line1;
            } else {
                currentN = currentLine.line2;
            }

//            if (n == 1) {
//                System.out.println("currentN: " + currentN + ", pos: " + currentLine.pos);
//            }
            line = findLine(currentN, currentLine.pos);
        }

    }

    private static Optional<Line> findLine(int n, int pos) {
        return Arrays.stream(lines)
                .filter(x -> (x.line1 == n || x.line2 == n) && x.pos > pos)
                .findFirst();
    }

    private static int c() {
        int answer = 0;
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                int finalI = i;
                int finalJ = j;
                int count = (int) Arrays.stream(lines).filter(x -> x.hasOwner(finalI) && x.hasOwner(finalJ)).count();

                if (count % 2 == 0) {
                    answer += count;
                }


            }
        }

        return answer;
    }

}
