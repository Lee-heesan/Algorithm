import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }

    public static int bfs() {
        boolean[] visited = new boolean[MAX + 1];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{N, 0});
        visited[N] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int now = cur[0];
            int count = cur[1];

            if (now == K) {
                return count;
            }

            int[] nexts = {now - 1, now + 1, now * 2};

            for (int nxt : nexts) {
                if (nxt >= 0 && nxt <= MAX && !visited[nxt]) {
                    visited[nxt] = true;
                    q.offer(new int[]{nxt, count + 1});
                }
            }
        }

        return -1;
    }
}