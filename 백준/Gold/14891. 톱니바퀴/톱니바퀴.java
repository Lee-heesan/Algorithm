import java.io.*;
import java.util.*;

public class Main {
    static int[][] gear = new int[4][8];

    static void rotate(int idx, int dir) {
        if (dir == 1) {
            int tmp = gear[idx][7];
            for (int i = 7; i >= 1; i--) gear[idx][i] = gear[idx][i - 1];
            gear[idx][0] = tmp;
        } else {
            int tmp = gear[idx][0];
            for (int i = 0; i < 7; i++) gear[idx][i] = gear[idx][i + 1];
            gear[idx][7] = tmp;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String s = br.readLine().trim();
            for (int j = 0; j < 8; j++) gear[i][j] = s.charAt(j) - '0';
        }

        int K = Integer.parseInt(br.readLine().trim());
        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            int[] dirs = new int[4];
            dirs[num] = dir;

            for (int i = num - 1; i >= 0; i--) {
                if (gear[i][2] != gear[i + 1][6]) dirs[i] = -dirs[i + 1];
                else break;
            }

            for (int i = num + 1; i < 4; i++) {
                if (gear[i - 1][2] != gear[i][6]) dirs[i] = -dirs[i - 1];
                else break;
            }

            for (int i = 0; i < 4; i++) {
                if (dirs[i] != 0) rotate(i, dirs[i]);
            }
        }

        int score = 0;
        if (gear[0][0] == 1) score += 1;
        if (gear[1][0] == 1) score += 2;
        if (gear[2][0] == 1) score += 4;
        if (gear[3][0] == 1) score += 8;

        System.out.println(score);
    }
}
