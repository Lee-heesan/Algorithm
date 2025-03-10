import java.io.*;
import java.util.*;

public class Solution {
    static int n;
    static int[][] cafe;
    static boolean[] dessert;
    static boolean[][] visited;
    static int max = -1;
    static int[] dy = { 1, 1, -1, -1 };
    static int[] dx = { 1, -1, -1, 1 };

    static void dfs(int y, int x, int sy, int sx, int dir, int cnt) {
        for(int i = dir; i <= dir + 1; i++) {
            if(i == 4)
                break;
            
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= n)
                continue;
            
            if(ny == sy && nx == sx) {
                max = Math.max(max, cnt);
                return;
            }

            if(dessert[cafe[ny][nx]] || visited[ny][nx])
                continue;

            dessert[cafe[ny][nx]] = true;
            visited[ny][nx] = true;
            dfs(ny, nx, sy, sx, i, cnt + 1);
            dessert[cafe[ny][nx]] = false;
            visited[ny][nx] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t <= tc; t++) {
            n = Integer.parseInt(br.readLine());
            cafe = new int[n][n];
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    cafe[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            max = -1;
            for(int i = 0; i < n - 2; i++) {
                for(int j = 1; j < n - 1; j++) {
                    dessert = new boolean[101];
                    visited = new boolean[n][n];
                    dessert[cafe[i][j]] = true;
                    visited[i][j] = true;
                    dfs(i, j, i, j, 0, 1);
                }
            }

            System.out.println("#" + t + " " + max);
        }
    }
}
