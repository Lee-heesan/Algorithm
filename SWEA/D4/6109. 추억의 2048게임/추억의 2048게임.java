import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N, S;
    static Map<String, Integer> map = new HashMap<>();
    static int[][] arr;
    static int[][] result;
    static int[] dx = {0, 0, -1, 1}; // left, right, up, down
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        map.put("left", 0);
        map.put("right", 1);
        map.put("up", 2);
        map.put("down", 3);

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            S = map.get(st.nextToken());

            arr = new int[N][N];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            
            result = moveAndMerge(S);

           
            sb.append("#").append(i).append("\n");
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    sb.append(result[j][k]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    public static int[][] moveAndMerge(int dir) {
        int[][] newBoard = new int[N][N];

        for (int i = 0; i < N; i++) {
            Deque<Integer> deque = new ArrayDeque<>();
            for (int j = 0; j < N; j++) {
                int val = (dir == 0) ? arr[i][j] : (dir == 1) ? arr[i][N - j - 1] :
                          (dir == 2) ? arr[j][i] : arr[N - j - 1][i];

                if (val != 0) deque.addLast(val);
            }

            Deque<Integer> merged = new ArrayDeque<>();
            while (!deque.isEmpty()) {
                int num = deque.pollFirst();
                if (!deque.isEmpty() && num == deque.peekFirst()) {
                    merged.addLast(num * 2);
                    deque.pollFirst();
                } else {
                    merged.addLast(num);
                }
            }

            while (merged.size() < N) merged.addLast(0);

            for (int j = 0; j < N; j++) {
                int val = merged.pollFirst();
                if (dir == 0) newBoard[i][j] = val;
                else if (dir == 1) newBoard[i][N - j - 1] = val;
                else if (dir == 2) newBoard[j][i] = val;
                else newBoard[N - j - 1][i] = val;
            }
        }
        return newBoard;
    }
}
