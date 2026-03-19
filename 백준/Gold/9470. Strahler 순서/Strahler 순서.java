import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] graph = new ArrayList[M + 1];
            for (int i = 1; i <= M; i++) {
                graph[i] = new ArrayList<>();
            }

            int[] indegree = new int[M + 1];

            for (int i = 0; i < P; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                graph[A].add(B);
                indegree[B]++;
            }

            int[] strahler = new int[M + 1];
            int[] maxIn = new int[M + 1];
            int[] count = new int[M + 1];

            Queue<Integer> q = new LinkedList<>();

            for (int i = 1; i <= M; i++) {
                if (indegree[i] == 0) {
                    strahler[i] = 1;
                    q.offer(i);
                }
            }

            while (!q.isEmpty()) {
                int cur = q.poll();

                for (int next : graph[cur]) {
                    if (strahler[cur] > maxIn[next]) {
                        maxIn[next] = strahler[cur];
                        count[next] = 1;
                    } else if (strahler[cur] == maxIn[next]) {
                        count[next]++;
                    }

                    indegree[next]--;

                    if (indegree[next] == 0) {
                        if (count[next] >= 2) {
                            strahler[next] = maxIn[next] + 1;
                        } else {
                            strahler[next] = maxIn[next];
                        }
                        q.offer(next);
                    }
                }
            }

            sb.append(K).append(" ").append(strahler[M]).append("\n");
        }

        System.out.print(sb);
    }
}