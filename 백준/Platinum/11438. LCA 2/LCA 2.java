
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, maxK;
    static List<Integer>[] tree;
    static int[] depth;
    static int[][] parentK;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        depth = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        // maxK 계산 (log2(N) + 1)
        maxK = 0;
        int tmp = N;
        while (tmp > 0) {
            tmp /= 2;
            maxK++;
        }

        parentK = new int[maxK + 1][N + 1];

        // BFS로 depth 설정 및 parent 설정
        bfs(1);

        // DP 테이블 채우기 (parentK)
        for (int i = 1; i <= maxK; i++) {
            for (int j = 1; j <= N; j++) {
                if (parentK[i - 1][j] != 0) {
                    parentK[i][j] = parentK[i - 1][parentK[i - 1][j]];
                }
            }
        }

        // 쿼리 처리
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(findLCA(a, b)).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        depth[start] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : tree[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    depth[next] = depth[now] + 1;
                    parentK[0][next] = now;
                    q.add(next);
                }
            }
        }
    }

    private static int findLCA(int a, int b) {
        if (depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = maxK; i >= 0; i--) {
            if (depth[b] - depth[a] >= (1 << i)) {
                b = parentK[i][b];
            }
        }

        if (a == b) return a;

        for (int i = maxK; i >= 0; i--) {
            if (parentK[i][a] != parentK[i][b]) {
                a = parentK[i][a];
                b = parentK[i][b];
            }
        }

        return parentK[0][a];
    }
}
