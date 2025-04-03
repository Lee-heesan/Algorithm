import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int N, K;
    static int[][] arr;
    static boolean[][] visited;
    static int max;
    static List<Node> [] info;
    static int[] dx = {0, 1, 0, -1}; // 위, 오른, 밑, 왼
    static int[] dy = {1, 0, -1, 0}; // 위, 오른, 밑, 왼
    static int re;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N][N];
            max = Integer.MIN_VALUE;

            info = new ArrayList[21]; 
            for (int k = 1; k < info.length; k++) {
                info[k] = new ArrayList<>();
            }

            
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                    info[arr[j][k]].add(new Node(k, j)); 
                    max = Math.max(max, arr[j][k]);
                }
            }

            re = Integer.MIN_VALUE; 
            visited = new boolean[N][N];

            
            for (Node n : info[max]) {
                climbing(n, 1, false); 
            }

            sb.append("#").append(i).append(" ").append(re).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void climbing(Node start, int road, boolean dig) {
        int nowX = start.x;
        int nowY = start.y;
        visited[nowY][nowX] = true;

       
        for (int i = 0; i < 4; i++) {
            int nextX = nowX + dx[i];
            int nextY = nowY + dy[i];

            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visited[nextY][nextX]) {
                if (arr[nextY][nextX] < arr[nowY][nowX]) { 
                    climbing(new Node(nextX, nextY), road + 1, dig);
                } else if (!dig && arr[nextY][nextX] - K < arr[nowY][nowX]) { 
                    
                    int originalHeight = arr[nextY][nextX];
                    arr[nextY][nextX] = arr[nowY][nowX] - 1; 
                    climbing(new Node(nextX, nextY), road + 1, true); 
                    arr[nextY][nextX] = originalHeight; 
                }
            }
        }

        re = Math.max(re, road);
        visited[nowY][nowX] = false; 
    }
}
