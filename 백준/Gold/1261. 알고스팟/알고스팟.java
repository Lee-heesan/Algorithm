import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class pos implements Comparable<pos> {
        int x;
        int y;
        int cnt;

        public pos(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(pos o) {
            return this.cnt - o.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            int idx = 0;
            for (String num : str) {
                arr[i][idx] = Integer.parseInt(num);
                idx++;
            }
        }

        System.out.println(bfs(new pos(0, 0, 0)));
    }

    public static int bfs(pos start) {
        PriorityQueue<pos> pq = new PriorityQueue<>();
        int[][] dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        pq.add(start);
        dist[start.y][start.x] = 0;

        while (!pq.isEmpty()) {
            pos nowPos = pq.poll();

            if (nowPos.x == M - 1 && nowPos.y == N - 1) {
                return nowPos.cnt;
            }

            if (dist[nowPos.y][nowPos.x] < nowPos.cnt) continue;

            for (int i = 0; i < 4; i++) {
                int nxtX = dx[i] + nowPos.x;
                int nxtY = dy[i] + nowPos.y;

                if (nxtX < 0 || nxtY < 0 || nxtX >= M || nxtY >= N) continue;

                int nextCnt = nowPos.cnt + arr[nxtY][nxtX];

                if (dist[nxtY][nxtX] > nextCnt) {
                    dist[nxtY][nxtX] = nextCnt;
                    pq.add(new pos(nxtX, nxtY, nextCnt));
                }
            }
        }
        return 0;
    }
}