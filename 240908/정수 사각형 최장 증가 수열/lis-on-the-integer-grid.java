import java.util.*;

class Cell implements Comparable<Cell> {
    int num, x, y;

    public Cell(int num, int x, int y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Cell c) {
        return this.num - c.num;
    }
}

public class Main {
    final static Scanner sc = new Scanner(System.in);
    
    static int N;
    static ArrayList<Cell> matrix = new ArrayList<>();

    static int[][] grid;
    static int[][] memo;
    static int ans;

    public static void main(String[] args) {
        N = sc.nextInt();

        memo = new int[N + 1][N + 1];
        grid = new int[N + 1][N + 1];

        initGrid();
        initalizeMatrix();

        Collections.sort(matrix);

        for (int i = 0; i < matrix.size(); i++) {
            final Cell cell = matrix.get(i);
            int x = cell.x;
            int y = cell.y;

            int[] dx = new int[]{-1, 1, 0, 0};
            int[] dy = new int[]{0, 0, -1, 1};

            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if (nx <= 0 || nx > N) {
                    continue;
                }

                if (ny <= 0 || ny > N) {
                    continue;
                }

                if (grid[nx][ny] > grid[x][y]) {
                    memo[nx][ny] = Math.max(memo[nx][ny], memo[nx][ny] + 1);
                }
            }
        }

        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= N; j++)
                ans = Math.max(ans, memo[i][j]);

        System.out.print(ans);
    }

    private static void initGrid() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                grid[i][j] = sc.nextInt();
                memo[i][j] = 1;
            }
        }
    }

    private static void initalizeMatrix() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                matrix.add(new Cell(memo[i][j], i, j));
            }
        }
    }
}