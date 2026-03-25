import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        int x = n / 2;
        int y = n / 2;
        arr[x][y] = 1;

        int targetX = x;
        int targetY = y;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int num = 2;
        int dist = 1;
        int dir = 0;

        while (num <= n * n) {
            for (int r = 0; r < 2; r++) {
                for (int i = 0; i < dist; i++) {
                    if (num > n * n) break;

                    x += dx[dir];
                    y += dy[dir];
                    arr[x][y] = num;

                    if (num == target) {
                        targetX = x;
                        targetY = y;
                    }

                    num++;
                }
                dir = (dir + 1) % 4;
            }
            dist++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        sb.append(targetX + 1).append(" ").append(targetY + 1);
        System.out.print(sb);
    }
}