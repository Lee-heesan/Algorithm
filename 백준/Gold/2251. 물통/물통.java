
import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static boolean[] possible;
    static int[] capacities = new int[3];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < 3; i++) {
            capacities[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[201][201];
        possible = new boolean[201];

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < possible.length; i++) {
            if (possible[i]) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, capacities[2]});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int a = current[0];
            int b = current[1];
            int c = current[2];

            // 첫 번째 물통이 비어 있을 때, 세 번째 물통의 물의 양을 기록
            if (a == 0) {
                possible[c] = true;
            }

            // 각 물통 간의 물 이동
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from != to) {
                        int[] next = {a, b, c};
                        int moveAmount = Math.min(next[from], capacities[to] - next[to]);
                        next[from] -= moveAmount;
                        next[to] += moveAmount;

                        if (!visited[next[0]][next[1]]) {
                            visited[next[0]][next[1]] = true;
                            queue.add(new int[]{next[0], next[1], next[2]});
                        }
                    }
                }
            }
        }
    }
}

