import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][][] visited; // 벽을 부순 여부를 포함한 방문 여부
    static int min = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M][2]; // 0: 벽 안 부심, 1: 벽 부심

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(min);
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, 0)); // 시작점 (x=0, y=0, 거리=1, 벽 안 부숨)
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            // 도착점에 도달하면 최단 거리 업데이트 후 종료
            if (now.y == N - 1 && now.x == M - 1) {
                min = now.count;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                // 범위 체크
                if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
                    // 벽을 부수지 않고 이동할 경우
                    if (arr[nextY][nextX] == 0 && !visited[nextY][nextX][now.broke]) {
                        queue.add(new Node(nextX, nextY, now.count + 1, now.broke));
                        visited[nextY][nextX][now.broke] = true;
                    }
                    // 벽을 만나고 한 번도 부수지 않은 경우 (한 번만 부술 수 있음)
                    else if (arr[nextY][nextX] == 1 && now.broke == 0 && !visited[nextY][nextX][1]) {
                        queue.add(new Node(nextX, nextY, now.count + 1, 1));
                        visited[nextY][nextX][1] = true;
                    }
                }
            }
        }
    }

    static class Node {
        int x, y, count, broke;

        public Node(int x, int y, int count, int broke) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.broke = broke;
        }
    }
}
