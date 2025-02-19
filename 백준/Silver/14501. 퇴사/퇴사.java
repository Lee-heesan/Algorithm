import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] T = new int[N + 1]; // 상담 기간
        int[] P = new int[N + 1]; // 상담 금액
        int[] dp = new int[N + 2]; // dp[i] : i일부터 퇴사일까지 얻을 수 있는 최대 수익

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // DP 테이블 채우기 (역순 탐색)
        for (int i = N; i > 0; i--) {
            if (i + T[i] > N + 1) {
                dp[i] = dp[i + 1]; // 상담을 할 수 없는 경우, 다음 날의 수익을 그대로 가져옴
            } else {
                dp[i] = Math.max(dp[i + 1], P[i] + dp[i + T[i]]); // 상담을 하지 않는 경우 vs 상담을 하는 경우
            }
        }

        System.out.println(dp[1]); 
    }
}
