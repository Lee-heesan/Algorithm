import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, M, C;
    static int[][] map;
    static int max;
    private static boolean[][] visited;

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
            
            visited = new boolean[N][N];
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
        
        maxProfit = findMaxProfit(i, j, 0, 0, 0); 
        
        return maxProfit;
    }


    private static int findMaxProfit(int i, int j, int idx, int sum, int sumSquare) {
        if (idx == M) {
            if (sum <= C) {
                return sumSquare;  
            }
            return 0;  
        }

      
        int maxProfit = findMaxProfit(i, j, idx + 1, sum, sumSquare);

       
        int newSum = sum + map[i][j + idx];
        int newSumSquare = sumSquare + map[i][j + idx] * map[i][j + idx];
        maxProfit = Math.max(maxProfit, findMaxProfit(i, j, idx + 1, newSum, newSumSquare));

        return maxProfit;
    }

}
