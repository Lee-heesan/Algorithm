import java.io.*;
import java.util.*;

public class Main {
    static int n, m;

    static class Edge {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    static long[] distance;
    static int[] parent;
    static List<Edge> edges;

    static List<Integer>[] graph;
    static List<Integer>[] reverseGraph;
    static boolean[] fromStart;
    static boolean[] toEnd;

    static void bfs(int start, List<Integer>[] g, boolean[] visited) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : g[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        distance = new long[n + 1];
        parent = new int[n + 1];
        graph = new ArrayList[n + 1];
        reverseGraph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        Arrays.fill(distance, Long.MIN_VALUE);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges.add(new Edge(u, v, w));
            graph[u].add(v);
            reverseGraph[v].add(u);
        }

        fromStart = new boolean[n + 1];
        toEnd = new boolean[n + 1];

        bfs(1, graph, fromStart);
        bfs(n, reverseGraph, toEnd);

        distance[1] = 0;

        boolean infinite = false;

        for (int i = 1; i <= n; i++) {
            for (Edge now : edges) {
                if (distance[now.start] == Long.MIN_VALUE) continue;

                if (distance[now.end] < distance[now.start] + now.cost) {
                    distance[now.end] = distance[now.start] + now.cost;
                    parent[now.end] = now.start;

                    if (i == n && fromStart[now.end] && toEnd[now.end]) {
                        infinite = true;
                    }
                }
            }
        }

        if (distance[n] == Long.MIN_VALUE || infinite) {
            System.out.println(-1);
            return;
        }

        List<Integer> path = new ArrayList<>();
        int cur = n;

        while (cur != 0) {
            path.add(cur);
            if (cur == 1) break;
            cur = parent[cur];
        }

        Collections.reverse(path);

        StringBuilder sb = new StringBuilder();
        for (int x : path) {
            sb.append(x).append(' ');
        }
        System.out.println(sb);
    }
}