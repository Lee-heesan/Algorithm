
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, M, C;
    static int[][] map;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new int[N][N];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            max = Integer.MIN_VALUE;
            dfs(0, 0, 0, 0);  // row, col, people (일꾼), sumPow (수익)

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void dfs(int row, int col, int people, int sumPow) {
        if (people == 2) {
            max = Math.max(max, sumPow); 
            return;
        }

       
        for (int i = row; i < N; i++) {
            for (int j = (i == row ? col : 0); j <= N - M; j++) {
                
                int maxProfit = getMaxSubsetProfit(i, j);
                
                
                dfs(i, j + M, people + 1, sumPow + maxProfit);  
            }
        }
    }

    
    private static int getMaxSubsetProfit(int i, int j) {
        int maxProfit = 0;
        
        
        for (int mask = 0; mask < (1 << M); mask++) {
            int sum = 0;
            int sumSquare = 0;

            
            for (int k = 0; k < M; k++) {
                if ((mask & (1 << k)) != 0) {
                    sum += map[i][j + k];
                    sumSquare += map[i][j + k] * map[i][j + k];
                }
            }

            
            if (sum <= C) {
                maxProfit = Math.max(maxProfit, sumSquare);
            }
        }

        return maxProfit;
    }
}
