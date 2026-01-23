import java.io.*;
import java.util.*;

public class Main {
    static int K, W, H;
    static int[][] map;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[] hx = {-2,-2,-1,-1, 1, 1, 2, 2};
    static int[] hy = {-1, 1,-2, 2,-2, 2,-1, 1};

    static boolean[][][] visited;

    static class Node {
        int x, y, k, d;
        Node(int x, int y, int k, int d) {
            this.x = x; this.y = y; this.k = k; this.d = d;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        visited = new boolean[H][W][K + 1];
        Queue<Node> q = new LinkedList<>();

        if (map[0][0] == 1) {
        	return -1;
        }

        visited[0][0][0] = true;
        q.add(new Node(0, 0, 0, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == W - 1 && cur.y == H - 1) {
                return cur.d;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= W || ny >= H) continue;
                if (map[ny][nx] == 1) continue;
                if (visited[ny][nx][cur.k]) continue;

                visited[ny][nx][cur.k] = true;
                q.add(new Node(nx, ny, cur.k, cur.d + 1));
            }

            if (cur.k < K) {
                for (int i = 0; i < 8; i++) {
                    int nx = cur.x + hx[i];
                    int ny = cur.y + hy[i];

                    if (nx < 0 || ny < 0 || nx >= W || ny >= H) continue;
                    if (map[ny][nx] == 1) continue;
                    if (visited[ny][nx][cur.k + 1]) continue;

                    visited[ny][nx][cur.k + 1] = true;
                    q.add(new Node(nx, ny, cur.k + 1, cur.d + 1));
                }
            }
        }
        return -1;
    }
}
