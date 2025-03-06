import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static char[][] map;
  //위, 오른위, 오른쪽, 오른밑, 아래, 왼밑, 왼쪽, 왼위
    static int[] dx = {0,1,1,1,0,-1,-1,-1}, dy = {1,1,0,-1,-1,-1,0,1};
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];

            for (int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();

            result = 0;
            markNumbers();
            bfs();

            for (char[] row : map)
                for (char c : row)
                    if (c != '*' && c != '-') result++;

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }

    
    static void markNumbers() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '.') {
                    int cnt = 0;
                    for (int d = 0; d < 8; d++) {
                        int nx = i + dx[d], ny = j + dy[d];
                        if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] == '*') cnt++;
                    }
                    map[i][j] = (char) (cnt + '0');
                }
            }
        }
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '0') {
                    result++;
                    q.add(new int[]{i, j});
                    map[i][j] = '-';

                    while (!q.isEmpty()) {
                        int[] node = q.poll();
                        for (int d = 0; d < 8; d++) {
                            int nx = node[0] + dx[d], ny = node[1] + dy[d];
                            if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] != '-') {
                                if (map[nx][ny] == '0') q.add(new int[]{nx, ny});
                                map[nx][ny] = '-';
                            }
                        }
                    }
                }
            }
        }
    }
}
