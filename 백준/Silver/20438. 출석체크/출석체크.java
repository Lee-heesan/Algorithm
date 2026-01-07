import java.io.*;
import java.util.*;

public class Main {
	static boolean[] sleep;
    static boolean[] attend;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int MAX = N + 2;

        sleep = new boolean[MAX + 1];
        attend = new boolean[MAX + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x <= MAX) sleep[x] = true;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            spread(Integer.parseInt(st.nextToken()));
        }

        int[] prefixAbsent = new int[MAX + 1];
        for (int i = 3; i <= MAX; i++) {
            prefixAbsent[i] = prefixAbsent[i - 1] + ((attend[i]) ? 0 : 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            sb.append(prefixAbsent[E] - prefixAbsent[S - 1]).append('\n');
        }	

        System.out.print(sb);
    }

    static void spread(int x) {
        if (x >= attend.length) return;
        if (sleep[x]) return;

        for (int i = x; i < attend.length; i += x) {
            if (!sleep[i] && !attend[i]) {
                attend[i] = true;
                spread(i);
            }
        }
    }
}