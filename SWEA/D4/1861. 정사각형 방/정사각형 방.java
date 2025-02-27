import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    
    static int N;
    static int[][] room;
    static int[][] dp;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int maxNum;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            room = new int[N][N];
            dp = new int[N][N]; // DP 배열 초기화
            
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    room[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            max = 0;
            maxNum = Integer.MAX_VALUE;

            // 모든 방에서 DFS 시작
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int length = dfs(i, j);
                    if (length > max) {
                        max = length;
                        maxNum = room[i][j];
                    } else if (length == max) {
                        maxNum = Math.min(maxNum, room[i][j]);
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(maxNum).append(" ").append(max).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int dfs(int y, int x) {
        if (dp[y][x] != 0) return dp[y][x]; // 이미 계산된 값이 있으면 재사용

        int maxLength = 1;

        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            if (newY >= 0 && newY < N && newX >= 0 && newX < N && room[newY][newX] == room[y][x] + 1) {
                maxLength = Math.max(maxLength, 1 + dfs(newY, newX));
            }
        }

        dp[y][x] = maxLength; // DP 테이블에 저장
        return maxLength;
    }
}
