import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시작 위치 (1,2) 가로 방향(0)
        dfs(1, 2, 0);

        System.out.println(result);
    }

    public static void dfs(int y, int x, int direction) {
        // 도착지 (N, N)에 도달하면 경우의 수 증가
        if (y == N && x == N) {
            result++;
            return;
        }

        // 가로 방향 (0)
        if (direction == 0) {
            if (x + 1 <= N && map[y][x + 1] == 0) {
                dfs(y, x + 1, 0);
            }
            if (x + 1 <= N && y + 1 <= N && map[y][x + 1] == 0 && map[y + 1][x] == 0 && map[y + 1][x + 1] == 0) {
                dfs(y + 1, x + 1, 2);
            }
        }

        // 세로 방향 (1)
        else if (direction == 1) {
            if (y + 1 <= N && map[y + 1][x] == 0) {
                dfs(y + 1, x, 1);
            }
            if (x + 1 <= N && y + 1 <= N && map[y][x + 1] == 0 && map[y + 1][x] == 0 && map[y + 1][x + 1] == 0) {
                dfs(y + 1, x + 1, 2);
            }
        }

        // 대각선 방향 (2)
        else if (direction == 2) {
            if (x + 1 <= N && map[y][x + 1] == 0) {
                dfs(y, x + 1, 0);
            }
            if (y + 1 <= N && map[y + 1][x] == 0) {
                dfs(y + 1, x, 1);
            }
            if (x + 1 <= N && y + 1 <= N && map[y][x + 1] == 0 && map[y + 1][x] == 0 && map[y + 1][x + 1] == 0) {
                dfs(y + 1, x + 1, 2);
            }
        }
    }
}
