import java.io.*;
import java.util.*;

public class Main {
    static class Doc {
        int idx, p;
        
        Doc(int idx, int p) { 
        	this.idx = idx; 
        	this.p = p;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Doc> q = new ArrayDeque<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int p = Integer.parseInt(st.nextToken());
                q.offer(new Doc(i, p));
                pq.offer(p);
            }

            int printed = 0;
            while (!q.isEmpty()) {
                Doc cur = q.poll();
                if (cur.p == pq.peek()) {     
                    pq.poll();
                    printed++;
                    if (cur.idx == M) {        
                        sb.append(printed).append('\n');
                        break;
                    }
                } else {
                    q.offer(cur);           
                }
            }
        }
        System.out.print(sb.toString());
    }
}
