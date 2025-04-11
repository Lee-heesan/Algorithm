import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int n, m;
    static List<Node>[] list;
    static int[] dist;
    static boolean[] visited;
    static int[] prev;

    static class Node implements Comparable<Node> {
        int city;
        int cost;

        public Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        dist = new int[n + 1];
        prev = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
            prev[i] = 0;
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list[s].add(new Node(e, d));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.city]) continue;
            visited[now.city] = true;

            for (Node next : list[now.city]) {
            	if (dist[next.city] > dist[now.city] + next.cost) {
            	    dist[next.city] = dist[now.city] + next.cost;
            	    prev[next.city] = now.city;
            	    pq.add(new Node(next.city, dist[next.city]));
            	}
            }
        }

        // 출력
        sb.append(dist[end]).append("\n");

        Stack<Integer> path = new Stack<>();
        int temp = end;
        while (temp != 0) {
            path.push(temp);
            temp = prev[temp];
        }


        sb.append(path.size()).append("\n");
        while (!path.isEmpty()) {
            sb.append(path.pop()).append(" ");
        }

        System.out.println(sb.toString());
    }
}
