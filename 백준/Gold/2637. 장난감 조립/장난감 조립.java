import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int to, cnt;

        Edge(int to, int cnt) {
            this.to = to;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Edge>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // Y -> X (Y가 있어야 X를 만들 수 있음)
            graph[Y].add(new Edge(X, K));
            indegree[X]++;
        }

        int[][] dp = new int[N + 1][N + 1];
        Queue<Integer> q = new LinkedList<>();

        // 기본 부품 찾기 (indegree == 0)
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                dp[i][i] = 1; // 자기 자신이 기본 부품
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Edge edge : graph[cur]) {
                int next = edge.to;
                int cnt = edge.cnt;

                // cur를 이용해서 next를 만들 때 필요한 기본 부품 수 누적
                for (int i = 1; i <= N; i++) {
                    dp[next][i] += dp[cur][i] * cnt;
                }

                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (dp[N][i] > 0) {
                sb.append(i).append(" ").append(dp[N][i]).append("\n");
            }
        }

        System.out.print(sb);
    }
}