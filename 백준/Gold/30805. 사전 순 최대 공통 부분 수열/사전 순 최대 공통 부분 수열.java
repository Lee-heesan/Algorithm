import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());  // 배열 A의 크기
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());  // 배열 B의 크기
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int idxA = 0;
        int idxB = 0;
        Queue<Integer> queue = new ArrayDeque<>();

        while (idxA < n && idxB < m) {
            int result = 0;
            for (int i = idxA; i < n; i++) {
                for (int j = idxB; j < m; j++) {
                    if (A[i] == B[j]) {
                    	result = Math.max(result, A[i]);
                    }
                }
            }

            if (result != 0) {
            	queue.offer(result);
                while (A[idxA] != result) {
                	idxA++;
                }
                while (B[idxB] != result) {
                	idxB++;
                }
                idxA++;
                idxB++;
            } else {
            	break;
            }
        }

        sb.append(queue.size()).append("\n");
        while (!queue.isEmpty()) {
        	sb.append(queue.poll()).append(" ");
        }
        System.out.println(sb.toString());

    }
}
