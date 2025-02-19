
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int m, k, t;
    static int[] D = new int[51];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); // 색상의 개수
        st = new StringTokenizer(br.readLine());
        t = 0; // 전체 돌 개수

        for (int i = 0; i < m; i++) {
            D[i] = Integer.parseInt(st.nextToken()); // 각 색상별 돌 개수
            t += D[i];
        }

        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken()); // 뽑을 돌의 개수

        double ans = 0.0;

        // 각 색상의 돌을 k개 모두 뽑을 확률 계산
        for (int i = 0; i < m; i++) {
            if (D[i] >= k) { // 해당 색상의 돌이 k개 이상 있어야 뽑을 가능성이 있음
                double probability = 1.0;
                for (int j = 0; j < k; j++) {
                    probability *= (double) (D[i] - j) / (t - j);
                }
                ans += probability;
            }
        }

        System.out.println(ans); // 최종 확률 출력
    }
}
