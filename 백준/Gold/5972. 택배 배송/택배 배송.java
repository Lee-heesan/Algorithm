import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] dist;
    static List<Cow>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        dist[1] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            list[A].add(new Cow(B, C));
            list[B].add(new Cow(A, C));
        }

        PriorityQueue<Cow> pq = new PriorityQueue<>();
        pq.offer(new Cow(1, 0));

        while (!pq.isEmpty()) {
            Cow now = pq.poll();

            if (visited[now.end]) {
            	continue;
            }
            
            visited[now.end] = true;

            for (Cow next : list[now.end]) {
                if (!visited[next.end] && dist[next.end] > dist[now.end] + next.cnt) {
                    dist[next.end] = dist[now.end] + next.cnt;
                    pq.offer(new Cow(next.end, dist[next.end]));
                }
            }
        }

        System.out.println(dist[N]);
    }

    static class Cow implements Comparable<Cow> {
        int end;
        int cnt;

        public Cow(int end, int cnt) {
            this.end = end;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Cow o) {
            return this.cnt - o.cnt;
        }
    }
}