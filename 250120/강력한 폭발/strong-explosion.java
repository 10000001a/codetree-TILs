
import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int bombCount;
    static int[][] grid;
    static Point[] points = new Point[10];
    static int answer = 0;

    public static void main(String[] args) {
        N = sc.nextInt();

        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();

                if (grid[i][j] == 1) {
                    points[bombCount] = new Point(i, j);
                    bombCount++;
                }
            }
        }

        Point target = points[0];
        x(0, 0);
        if (target.x - 2 >= 0)
            grid[target.x - 2][target.y]--;
        if (target.x - 1 >= 0)
            grid[target.x - 1][target.y]--;
        if (target.x + 1 <= N - 1)
            grid[target.x + 1][target.y]--;
        if (target.x + 2 <= N - 1)
            grid[target.x + 2][target.y]--;
        x(0, 1);
        if (target.x - 1 >= 0)
            grid[target.x - 1][target.y]--;
        if (target.x + 1 <= N - 1)
            grid[target.x + 1][target.y]--;
        if (target.y - 1 >= 0)
            grid[target.x][target.y - 1]--;
        if (target.y + 1 <= N - 1)
            grid[target.x][target.y + 1]--;
        x(0, 2);
        if (target.x - 1 >= 0 && target.y - 1 >= 0)
            grid[target.x - 1][target.y - 1]--;
        if (target.x - 1 >= 0 && target.y + 1 <= N - 1)
            grid[target.x - 1][target.y + 1]--;
        if (target.x + 1 <= N - 1 && target.y - 1 >= 0)
            grid[target.x + 1][target.y - 1]--;
        if (target.x + 1 <= N - 1 && target.y + 1 <= N - 1)
            grid[target.x + 1][target.y + 1]--;

        System.out.println(answer);
    }

    private static void x(int phase, int bomb) {
        Point target = points[phase];
        if (bomb == 0) {
            if (target.x - 2 >= 0)
                grid[target.x - 2][target.y]++;

            if (target.x - 1 >= 0)
                grid[target.x - 1][target.y]++;

            if (target.x + 1 <= N - 1)
                grid[target.x + 1][target.y]++;

            if (target.x + 2 <= N - 1)
                grid[target.x + 2][target.y]++;
        }

        if (bomb == 1) {
            if (target.x - 1 >= 0)
                grid[target.x - 1][target.y]++;
            if (target.x + 1 <= N - 1)
                grid[target.x + 1][target.y]++;
            if (target.y - 1 >= 0)
                grid[target.x][target.y - 1]++;
            if (target.y + 1 <= N - 1)
                grid[target.x][target.y + 1]++;
        }
        if (bomb == 2) {
            if (target.x - 1 >= 0 && target.y - 1 >= 0)
                grid[target.x - 1][target.y - 1]++;
            if (target.x - 1 >= 0 && target.y + 1 <= N - 1)
                grid[target.x - 1][target.y + 1]++;
            if (target.x + 1 <= N - 1 && target.y - 1 >= 0)
                grid[target.x + 1][target.y - 1]++;
            if (target.x + 1 <= N - 1 && target.y + 1 <= N - 1)
                grid[target.x + 1][target.y + 1]++;
        }

        if (phase == bombCount - 1) {
            answer = Math.max(answer, count_destroied());
            return;
        }
        target = points[phase + 1];

        x(phase + 1, 0);
        if (target.x - 2 >= 0)
            grid[target.x - 2][target.y]--;
        if (target.x - 1 >= 0)
            grid[target.x - 1][target.y]--;
        if (target.x + 1 <= N - 1)
            grid[target.x + 1][target.y]--;
        if (target.x + 2 <= N - 1)
            grid[target.x + 2][target.y]--;

        x(phase + 1, 1);
        if (target.x - 1 >= 0)
            grid[target.x - 1][target.y]--;
        if (target.x + 1 <= N - 1)
            grid[target.x + 1][target.y]--;
        if (target.y - 1 >= 0)
            grid[target.x][target.y - 1]--;
        if (target.y + 1 <= N - 1)
            grid[target.x][target.y + 1]--;

        x(phase + 1, 2);
        if (target.x - 1 >= 0 && target.y - 1 >= 0)
            grid[target.x - 1][target.y - 1]--;
        if (target.x - 1 >= 0 && target.y + 1 <= N - 1)
            grid[target.x - 1][target.y + 1]--;
        if (target.x + 1 <= N - 1 && target.y - 1 >= 0)
            grid[target.x + 1][target.y - 1]--;
        if (target.x + 1 <= N - 1 && target.y + 1 <= N - 1)
            grid[target.x + 1][target.y + 1]--;
    }

    private static int count_destroied() {
        int c = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] > 0) {
                    c++;
                }
            }
        }

        return c;
    }
}
